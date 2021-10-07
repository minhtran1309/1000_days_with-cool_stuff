import qupath.lib.gui.QuPathGUI

hierarchy = getCurrentHierarchy()
def annotations = getAnnotationObjects()
for (annotation in annotations)
{
hierarchy.getSelectionModel().clearSelection();
selectObjects{p -> p == annotation}
saveDetectionMeasurements("/Volumes/BiomedML/Projects/QuPath_projects/STRISH_polaris/"+"export/"+"1007_detections.txt")

}