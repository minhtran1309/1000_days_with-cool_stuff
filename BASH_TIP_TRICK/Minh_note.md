# Note during running

### Reference genomes: 

* release July 24, 2019
```
wget ftp://ftp.ensembl.org/pub/release-93/fasta/mus_musculus/dna/Mus_musculus.GRCm38.dna.primary_assembly.fa.gz
gunzip Mus_musculus.GRCm38.dna.primary_assembly.fa.gz
```

genecode: genecode.vM24.annotation.gtf
```
wget ftp://ftp.ebi.ac.uk/pub/databases/gencode/Gencode_mouse/release_M24/gencode.vM24.annotation.gtf.gz
gunzip genecode.vM24.annotation.gtf
```
### For STAR alignment

First time running, we need to run the genomeGenerate mode first to creat indices generation
Quote
`--runMode genomeGenerate option directs STAR to run genome indices generation job.`

* Command: change the directory accordingly
```
STAR --runThreadN 12 --runMode genomeGenerate --genomeDir /shares/common/users/m.sanchez/genomes/mm10 --genomeFastaFiles /shares/common/users/m.sanchez/genomes/mm10/Mus_musculus.GRCm38.dna.primary_assembly.fa --outFileNamePrefix /shares/common/users/m.sanchez/genomes/mm10/Mus_musculus.GRCm38.dna.primary_assembly.starIdx
```
by doing this we would have a reference genome and index the genes. the next run would be `--runMode alignReads` and map to the last run of reference genome

possible error:
```
Fatal INPUT FILE error, no valid exon lines in the GTF file: /QRISdata/Q1287/Minh_envs/reference_mm10/gencode.vM24.annotation.gtf
Solution: check the formatting of the GTF file. Most likely cause is the difference in chromosome naming between GTF and FASTA file
```

Typically, the fastq files are zipped. but in case the fastq files are not compressed -> remove option `--readFilesCommand zcat `


### Directories clarification
there are plenty of directories that are named 

* MOAGR_RNASeq/00_sabre_demultiplexed_PE/ --> BGI data paired end mode demultiplexed
* MOAGR_RNASeq/00_sabre_dempltiplexed_combined/ --> BGI single end mode demultiplexed
* RNAseq/01_demultiplex/ --> HiSeq data demultiplexed

