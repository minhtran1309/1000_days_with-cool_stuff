#!/bin/bash
#PBS -A UQ-IMB
#PBS -N cutadapt_19_05010_24
#PBS -l walltime=14:00:00
#PBS -l select=1:ncpus=10:mem=64GB
#PBS -e /30days/s4596423/Algin_output/cutadapt_19-05010-24_error.txt
#PBS -o /30days/s4596423/Algin_output/cutadapt_19-05010-24_output.txt

printf "Start Running\n"
#module load anaconda/5.2.0
#source activate /QRISdata/Q1287/Minh_envs/rnaseq_qc/

BASE='/QRISdata/Q1287/MOAGR_RNASeq/00_original_BGI_data/19-05010-24/L1_Pool25_TubeID-19-05010-24-'
OUTPUT='/QRISdata/Q1287/MOAGR_RNASeq/02_STAR_BAM_original_BGI_data/'
GENOMEDIR='/QRISdata/Q1287/Minh_envs/reference_mm10/mm10/'
GTFFILE='/QRISdata/Q1287/Minh_envs/reference_mm10/gencode.vM24.chr_patch_hapl_scaff.annotation.gtf'
ADAPTER='/QRISdata/Q1287/AgingAtlas/RNAseq/qsub_scripts/adapter.fa'
printf "$(cutadapt --version)"
#ffor i in 1 2 3 4 5 6 7 8 9 10 11 12 13 14
for i in 13
do 
    dirname="${BASE}${i}/"
    echo "${dirname}"
    read1="$(ls ${dirname}*${i}_1.fq.gz)"
    read2="$(ls ${dirname}*${i}_2.fq.gz)"
    echo "${read1}"
    echo  "${read2}" 
    fn1="${read1##*/}"
    fn2="${read2##*/}"
    fn1="${fn1%.fq.gz}"
    fn2="${fn2%.fq.gz}"
    #echo "${fn1}" "${fn2}"
    #echo "${read1}"
    echo "${dirname}${fn1}.trimmed.fastq.gz"
    run_cut1="$(cutadapt -b file:${ADAPTER} --out ${dirname}${fn1}.trimmed.fq.gz ${read1})"      
    run_cut2="$(cutadapt -b file:${ADAPTER} --out ${dirname}${fn2}.trimmed.fq.gz ${read2})"      
    #run_star="$(STAR --runThreadN 12 --runMode alignReads --genomeDir ${GENOMEDIR} --readFilesIn ${read1} ${read2} --readFilesCommand zcat --outFileNamePrefix ${OUTPUT}${fn1}.03. --outSAMtype BAM SortedByCoordinate --outSAMunmapped Within --outFilterMatchNminOverLread 0.3 --outFilterScoreMinOverLread 0.3 --twopassMode Basic --sjdbGTFfile ${GTFFILE} 75 --quantMode GeneCounts)"


done
printf "\nDone\n"


