import qupath.lib.gui.QuPathGUI
import qupath.lib.gui.images.servers.RenderedImageServer
import qupath.lib.gui.viewer.overlays.HierarchyOverlay
import java.lang.ProcessBuilder
import qupath.ext.stardist.StarDist2D

// This step takes long to run
def pathModel = '/Volumes/BiomedML/Projects/QuPath_projects/CellSegmentationModels/dsb2018_heavy_augment.pb'

def stardist = StarDist2D.builder(pathModel)
        .threshold(0.33)             // Probability (detection) threshold
        .channels('DAPI (DAPI)')            // Select detection channel  
        .normalizePercentiles(1, 99)// Percentile normalization
        .pixelSize(0.5)              // Resolution for detection
        .cellExpansion(2.0)          // Approximate cells based upon nucleus expansion
        .cellConstrainScale(1.5)     // Constrain cell expansion using nucleus size
        .measureShape()              // Add shape measurements
        .measureIntensity()          // Add cell measurements (in all compartments)
        .includeProbability(true)    // Add probability as a measurement (enables later filtering)
        .build()

// Run detection for the selected objects
def imageData = getCurrentImageData()
def pathObjects = getSelectedObjects()
if (pathObjects.isEmpty()) {
    Dialogs.showErrorMessage("StarDist", "Please select a parent object!")
    return
}

stardist.detectObjects(imageData, pathObjects)

1/0

hierarchy = getCurrentHierarchy()
def base_path = "/Volumes/BiomedML/Projects/QuPath_projects/STRISH_polaris/export/"
def detection_report_fn = '1007_detections.txt'
def annotations = getAnnotationObjects()
for (annotation in annotations)
{
hierarchy.getSelectionModel().clearSelection();
selectObjects{p -> p == annotation}

saveDetectionMeasurements(base_path+detection_report_fn)
}


""" 
// Export Full poligon geometry infor for high-res visualization
boolean prettyPrint = false 
// false results in smaller file sizes and thus faster loading times, at the cost of nice formating

def gson = GsonTools.getInstance(prettyPrint)
def detections = getDetectionObjects()


File file = new File(base_path+"1007_detection_polygon.json")
 file.withWriter('UTF-8') {
     gson.toJson(detections,it)
 }
"""


// Render current view reference image
double downsample = 8

def viewer = getCurrentViewer()
def imageData2 = getCurrentImageData()
def roi = getSelectedROI()
// Create a rendered server that includes a hierarchy overlay using the current display settings
// if specify with layers, the rendered image may show the overlay of detection or annotation together
// def server = new RenderedImageServer.Builder(imageData)
//     .downsamples(downsample)
//     .layers(new HierarchyOverlay(viewer.getImageRegionStore(), viewer.getOverlayOptions(), imageData))
//     .build()

def server = new RenderedImageServer.Builder(imageData2)
    .downsamples(downsample)
    .build()


def ref_image_fn = '1007_R01_reference_rgb.png' 
writeImage(server, base_path+ref_image_fn)

logger.info( "Running Python Script" )



"""
USE inheritable script to run the QC
"""

def env_folder = '/Users/uqmtra12/miniconda3/envs/ultimate_env/bin/python'

// The location of the script that will process the images and return RoiSets
def python_file = '/Volumes/BiomedML/Projects/QuPath_projects/STRISH_polaris/export/strish_packages.py'

def parameters = ["save_fn_expression_ranking":'QC_1_figure.png', 'save_fn_expression_hist':'QC_2_figure.png','clip_min':0.05,'clip_max':0.95]
def parameters_strs = parameters.collect{ key, value -> return "--${key}=${value}" }

def pb =  new ProcessBuilder(env_folder, python_file, base_path, 
	'--report_fn='+detection_report_fn,
	'--ref_img_fn='+ref_image_fn,
	*parameters_strs).redirectErrorStream( true )

def process = pb.start()
def sout = new StringBuilder()
logger.info( "Started command: {}", pb.command().join(" "))

while ( process.isAlive() ) {

    if ( sout.size() > 0 ) {
        logger.info( sout.toString() )
        sout.setLength( 0 )
    }

    sleep( 200 )

}
logger.info( "Running Python Script Complete" )
print('Done')

