# [Tool name: QuPath](https://github.com/qupath/qupath)

## Getting Started

QuPath is an open source software for WSI analysis and digital pathology

List of features can be listed as follows:
1. WSI viewing (alternative tool for Openslide)
2. Biomarker quantification
3. Tissue microarray support 
    - dearraying of TMA, able to view related cores side-by-side
4. Sophisticated tumor identification using tumor identification for applied to slides of interest - including slides stained for immune cells without the need to stain for a separate tumor marker.
5. Flexible object classification
6. Analysis and export report

### Analysis (the extension and manual annotation, counting cell are excluded due to out of analysis scope)

#### Detecting Object (cell detection):
1. Abs: Manuallly drawing regions and counting object are cool but don't scale well to hadling large number of objects. The tool offers the capability to `detecting objects` with higher accuracy and less bias. 
2. Step by step: 

    a. Load the image (remember there is a step to select the image type, by default is `Not set` it must be `HE` or `Brightfiel (H-DAB)` in order to facilitate the object detection step)

    b. it has to be annotated in order to perform cell analysis/detection. Go to annotation tools, annotate some area of interest.
  
    c. Get it work by selecting Analyze -> cell analysis -> positive cell dectection. In fact default values should be enough but it's alway good to learn more about the parameter: 
      * The **score compartment value of Nucleus: DAB OD means that the decision will be based on the average DAB (brown) staining within the nucleus.** -> **The other compartments are useful in cases where the biomarker of interest isn't localized to the nucleus.** 
      * There are three different threshold below **Score Compartment** to adjust thresholds of color according to staining intensity which is useful for multiple intensity clssification.  
      * Choosing parameter can be tricky
    d. After detection completed, select `Annotation` tab (next to tab Project and Image), there will be a detail information about the number of positive and negative cells dectected in the lower panel. Besides. it's possible to view cell-by-cell results by selecting tab hierachy (alternatively, select Measure -> show detection measurements. From detection result, it's possible to view histogram, sort columns, select individual cell. 
      * The histogram helps to determine what threshold is most appropriate to apply to the Necleus: DAB OD mean measurements to determine if a cell is postive or not. 
3. Hierachy property: after cell detection, we can draw a sub-annotation **inside (remember inside not overlapping)** the area that performed dectection and evaluate the positive and negative percentage with this area. It runs quite slow in hierachy mode.  
4. Tab workflow allows you to keep track of your cell detection settings (works as a queue, the bottom one is the last command).  
### Classifying Objects
1. Abs: This aims to build a classifying model to distinguish between defferent cell types itself. More general than using `positive cell detection` it only perform cell detection. 
2. Step by step:

    a. Load the image (set type of the image to either `HE` or Brightfield `(H-DAB)` in orger to facilitate the object detection). Wait, why is object dectection?? Yea we want to detect object first and then build an object classification later. 
    
    b. Use `Annotation tool` to create annotation as normal (rect, elipse. brush tool, etc, except line.
    
    c. After annotations have been drawn (we need more than one), **must assign class to each annotation by right click to each annotation or by using `set class` button under `Annotation tab`**. Should notice the number increase inside each class (which means the number of cells inside all the annotation of this class).
    
    d. Continue creating annotations and assigning their classes. 
    
    e. Once we have sufficient number of annotations with different classes, it's time to create the classifier. Go to Classify -> Create detection classifier. Pressing `Build & Apply` will train up a classifier. That step will collect information from annotated classes to build a multple-class classifier. 
    
    d. Press `CMD + l` to show command list, search for `detection classifier`. That step will open `Create detection classifier` press auto update. In the detail box we can see the classes are listed under classifier classes. There are a few classifying algorithms type we can pick to build a classifier such as `Random Trees (default), Decision Trees, KNNs or Neural Network`. 

### Scripting in v0.2.0
1. To make a automative pipeline that can apply everywhere without problem we need script not GUI tools.
2. What should know in advance?

    * 


