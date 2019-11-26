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
  
    d. After detection completed, select `Annotation` tab (next to tab Project and Image), there will be a detail information about the number of positive and negative cells dectected in the lower panel. 
  

### Sentences



---
