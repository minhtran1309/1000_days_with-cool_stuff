#!/bin/bash
#PBS -A UQ-IMB
#PBS -N FASTQC_mtran
#PBS -l walltime=03:00:00
#PBS -l nodes=1:ncpus=10,mem=64GB
#PBS -e /30days/s4596423/FastQC_output/qc_19-04940-57_error.txt
#PBS -o /30days/s4596423/FastQC_output/qc_19-04940-57_output.txt

printf "Start Running\n"
#module load anaconda/5.2.0
#source activate /QRISdata/Q1287/Minh_envs/rnaseq_qc/
printf "\nModule loaded and environment activated\n"

basePath='/QRISdata/Q1287/MOAGR_RNASeq/00_sabre_demultiplexed_PE/Lane_1_samples/'
outputPath='/30days/s4596423/FastQC_output/'

for i in 1 3 4 6 7 8 9 10 12 13 14 15 17 18
do 
    dirname="${basePath}"
    #echo "${dirname}"
    read1="$(ls ${dirname}*-${i}_*_R1.fastq)"
    read2="$(ls ${dirname}*-${i}_*_R2.fastq)"
    echo "${read1}"
    echo "${read2}"
    echo '--------------------'
done
printf "\nDone\n"


