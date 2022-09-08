#!/bin/bash
#PBS -A UQ-IMB
#PBS -N correct_fastq
#PBS -l walltime=05:00:00
#PBS -l nodes=1:ncpus=10,mem=64GB
#PBS -e /30days/s4596423/correct_fastq_error.txt
#PBS -o /30days/s4596423/correct_fastq_output.txt

printf "Start Running\n"
#module load anaconda/5.2.0
#source activate /QRISdata/Q1287/Minh_envs/rnaseq_qc/
printf "\nModule loaded and environment activated\n"

basePath='/QRISdata/Q1287/MOAGR_RNASeq/00_sabre_demultiplexed_PE/Lane_1_samples/'
#basePath='/QRISdata/Q1287/MOAGR_RNASeq/00_original_BGI_data/19-04940-57/L2_Pool26_TubeID-19-04940-57-1/'
outputPath='/30days/s4596423/FastQC_output/'

cat ${basePath}0608-18_TCGACGTC_R1.fastq | awk 'NR%4==3{$0="+"};1' >> fixed.fastq

