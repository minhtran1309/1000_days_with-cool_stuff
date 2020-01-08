# My note of using MCD Viewer to generate tiff images from MCD viewer
### In a nutshell 
Step 1: As always select the mcd file from storage
Step 2: Choose a ROI to load (belows Panorama
Step 3: Select the channel and assign color to each channel of interest. After selecting enough channel, 
we can see them in Merged Tab in the right panel. Noted that it looks not so detailed. 
Step 4: Since it doesn't look good, here come the Channel Settings box. Adjust Channel Setting is in the bottom of left pannel

  a. Select a channel in the channel list
  b. To increase or decrease the signal range displayed in the marge image, adjust the threshold Min and Threshold Max using text box
  or adjusting the slider.
  c. Don't bother adding scale bar (drop down list in the second line of the right pannel), take the note and skip it. 
Step 5: Save a Merge Image (in most cases, overlaid optical images or objects are not saved. 

Extra: 
Selected Regopm Summary: You are capable of selecting a region and generate basic statistical data for selected 
areas within the merge image. Basic stats include: Min/Max the channel signal. Sum of all the channel signal values 
within the selected region. 

# In detail
### Export Imaging Data
each TIFF and OME-TIFF file header contains tags that define the raster image data that is specific to each channel. OME-TIFF can retain metadata
block in the OME-TIFF header. It includes the: instrument ID, Image ID, Name (channel name). Pixel dimensionOrder, Channel ID and Name, etc.
#### Export to OME-TIFF. --> (only export grayscale image)
1 Open the MCD file from local hard drive
