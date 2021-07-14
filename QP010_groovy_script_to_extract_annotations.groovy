import qupath.lib.objects.PathAnnotationObject
import qupath.lib.roi.PointsROI 
import qupath.lib.geom.Point2
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.JsonElement
import java.util.Arrays
def annotations = getAnnotationObjects()
print("\t"*4+"Begin")
def count = 0
def multiple_line_str = String.format("\t"*2+ "Line 1"+
	"\n"+"\t"*3+ "Line 2,"+
	"\n"+"\t"*4 +"Line 3")
print(multiple_line_str)

def get_json_from_array(PathAnnotationObject annot_object, int addition_tab = 0) {
    def tab_indent = annot_object.getLevel()
    if (annot_object.getChildObjects().size() == 0)
    {
    	// print('I am Here')
    	if (annot_object.getROI() instanceof PointsROI) {
    		String current_str = String.format("\t"*(tab_indent+addition_tab)+"{\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Class\": \"%s\",\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Name\": \"%s\",\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"RoiType\": \"%s\",\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Geometry\": {\n"+
"\t"*(tab_indent+1+addition_tab)+ "\t\"CentroidX\": %f,\n"+
"\t"*(tab_indent+1+addition_tab)+ "\t\"CentroidY\": %f,\n"+
"\t"*(tab_indent+1+addition_tab)+ "\t\"Polygon_Points\": %s,\n"+			
"\t"*(tab_indent+1+addition_tab)+ "},\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Measurements\": {\n"+
"\t"*(tab_indent+1+addition_tab)+ "\t\"Area\": %f,\n"+
"\t"*(tab_indent+1+addition_tab)+ "\t\"Perimeter\": %f\n"+
"\t"*(tab_indent+1+addition_tab)+ "},\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Level\": %d,\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Number_Children\": %d,\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Children\": null,\n"+
"\t"*(tab_indent+addition_tab)+ "},",annot_object.getPathClass(), annot_object.getPathClass(), annot_object.getROI().getROIType(),annot_object.getROI().getCentroidX(),annot_object.getROI().getCentroidY(),annot_object.getROI().getPolygonPoints().collect{String.format("\n"+"\t"*(tab_indent+3+addition_tab)+"[%f,%f]", it.getX(), it.getY())},-1.0,-1.0,annot_object.getLevel(),annot_object.getChildObjects().size())
	return current_str +"\n"
    }
    	else {
    	String current_str = String.format("\t"*(tab_indent+addition_tab)+"{\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Class\": \"%s\",\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Name\": \"%s\",\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"RoiType\": \"%s\",\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Geometry\": {\n"+
"\t"*(tab_indent+1+addition_tab)+ "\t\"CentroidX\": %f,\n"+
"\t"*(tab_indent+1+addition_tab)+ "\t\"CentroidY\": %f,\n"+
"\t"*(tab_indent+1+addition_tab)+ "\t\"Polygon_Points\": %s,\n"+			
"\t"*(tab_indent+1+addition_tab)+ "},\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Measurements\": {\n"+
"\t"*(tab_indent+1+addition_tab)+ "\t\"Area\": %f,\n"+
"\t"*(tab_indent+1+addition_tab)+ "\t\"Perimeter\": %f\n"+
"\t"*(tab_indent+1+addition_tab)+ "},\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Level\": %d,\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Number_Children\": %d,\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Children\": null,\n"+
"\t"*(tab_indent+addition_tab)+ "},",annot_object.getPathClass(), annot_object.getPathClass(), annot_object.getROI().getROIType(),annot_object.getROI().getCentroidX(),annot_object.getROI().getCentroidY(),annot_object.getROI().getPolygonPoints().collect{String.format("\n"+"\t"*(tab_indent+3+addition_tab)+"[%f,%f]", it.getX(), it.getY())},annot_object.getROI().getArea(),annot_object.getROI().getPerimeter(),annot_object.getLevel(),annot_object.getChildObjects().size())
		return current_str +"\n"
    	}
    	
    } else{
    	// String current_str = String.format('TBD Here')
    	String current_str = String.format("\t"*(tab_indent+addition_tab)+"{\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Class\": \"%s\",\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Name\": \"%s\",\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"RoiType\": \"%s\",\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Geometry\": {\n"+
"\t"*(tab_indent+1+addition_tab)+ "\t\"CentroidX\": %f,\n"+
"\t"*(tab_indent+1+addition_tab)+ "\t\"CentroidY\": %f,\n"+
"\t"*(tab_indent+1+addition_tab)+ "\t\"Polygon_Points\": %s,\n"+			
"\t"*(tab_indent+1+addition_tab)+ "},\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Measurements\": {\n"+
"\t"*(tab_indent+1+addition_tab)+ "\t\"Area\": %f,\n"+
"\t"*(tab_indent+1+addition_tab)+ "\t\"Perimeter\": %f\n"+
"\t"*(tab_indent+1+addition_tab)+ "},\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Level\": %d,\n"+
"\t"*(tab_indent+1+addition_tab)+ "\"Number_Children\": %d,\n",annot_object.getPathClass(), annot_object.getPathClass(), annot_object.getROI().getROIType(),annot_object.getROI().getCentroidX(),annot_object.getROI().getCentroidY(),annot_object.getROI().getPolygonPoints().collect{String.format("\n"+"\t"*(tab_indent+3+addition_tab)+"[%f,%f]", it.getX(), it.getY())},annot_object.getROI().getArea(),annot_object.getROI().getPerimeter(),annot_object.getLevel(),annot_object.getChildObjects().size())
    	String child_str = String.format("")
    	for (child_annot in annot_object.getChildObjects()) {
		// return current_str
			child_str += get_json_from_array(child_annot, 1)
			// print('I come here already, Look what I found') 
    	}
    	
    	String out_str = String.format("%s"+
"\t"*(tab_indent+1)+ "\"Children\":[\n"+
"\t"*(tab_indent+1)+ "%s"+
"\t"*(tab_indent+1+addition_tab)+  "]\n",current_str, child_str)  
    	return out_str + "\t"*(tab_indent+addition_tab)+"},\n"
    }
	
    
}

def export_detector_cell_json(ArrayList<PathAnnotationObject> annotation_objects) {

  ArrayList<String> measurement_values = new ArrayList<String>()
  // print(detections_info)
  for (int c = 0; c < detections_info.size(); c++) {
    // print(detections_info[c].getPolygonPoints())
    String current_str = String.format("Name: %s, ROI: %s, Centroid X: %s, Centroid Y: %s, %s",detections_info[c].getPathClass(), detections_info[c].getNucleusROI().getRoiName(), detections_info[c].getNucleusROI().getCentroidX(), detections_info[c].getNucleusROI().getCentroidY(), detections_info[c].getMeasurementList().toString())
    measurement_values.add(current_str)
  }
  measure_json = get_json_from_array(measurement_values)
  String filename =  String.format('%s/measurement_values_%s.json',save_path,channel_name)
  File json_before = new File(filename)
  json_before.write(measure_json)
}


print(annotations.size())
def str_annot = "[\n"
for (annot in annotations) {
//	count += 1
//	print(annot)
//	print(annot.getClass())
	if (annot.getLevel() < 2){
		str_annot += get_json_from_array(annot)
		count += 1
		print("Hierachy:"+count)
	}
	// if (count == 0)
	// {
	// 	count += 1
	// }
	// else{
	// 	if (annot.getLevel() < 2){
	// 		count += 1
	// 		str_annot += get_json_from_array(annot)
	// 		// print(str_annot)
	// 		// print(annot.getROI().getPolygonPoints().getClass())
	// 		// def point_str = annot.getROI().getPolygonPoints().collect{String.format("\n[%f,%f]", it.getX(), it.getY())}
	// 		// print(point_str)
	// 		// print(annot.getROI().getPolygonPoints()[0].getClass())
	// 		// print(annot.getROI().getPolygonPoints()[0].getX())
	// 		// print(annot.getROI().getPolygonPoints()[0].getY())
	// 		// print(annot.getROI().getPolygonPoints().join(', \n\t\t\t\t\t'))
	// 		print('------------------\n')
 //    	}   
	// }
	// if(count > 2) {
	// 	break
	// }
}
str_annot += "\n]"
File json_before = new File('/Volumes/BiomedML/Pathology_landscape/Jun2021_OsmondAnnotatedImages/Q010_scripts/0712_CR048_All_Annot_geojson.json')
json_before.write(str_annot)
print(count)
print('Done')