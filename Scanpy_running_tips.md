Update infor
--------
Updated 20200313 by Minh


Detail
-------
Running scanpy tips and tricks

```
create conda environment with python and R in the same environment
* in R: install the following packages:
scran, RColorBrewer, slingshot, monocle, 
gam, clusterExperiment, ggplot2, plyr, MAST, Seurat

* in python: scanpy, gprofiler, pandas, rpy2, anndata2ri
```

### Note 1: 

For scanpy it's very easy to install but for `rpy2` and `anndata2ri`  it's a bit pain.
The solution is available on internet. 

### Note 2:

Usually, I run scanpy on jupyter notebook, so it's very interactive to import R package into python script with 

```
pandas2ri.activate()
anndata2ri.activate()
``` 

### Note 3: 

In order to import Seurat to Scanpy script: to avoid `Segmentation Failed Error`
By the time I wrote this note, the Scanpy version I use is: 
```
sc.logging.print_versions()
```

```
scanpy==1.4.5.post3 anndata==0.7.1 umap==0.3.10 numpy==1.18.1 scipy==1.4.1 pandas==1.0.3 scikit-learn==0.22.1 statsmodels==0.11.0 python-igraph==0.7.1 louvain==0.6.1
```

I changed from Seurat v3.1.0 to Seurat v3.0.2.

```
devtools::install_github(repo = 'satijalab/seurat@v3.0.2', dependencies=FALSE, force=TRUE)
```


