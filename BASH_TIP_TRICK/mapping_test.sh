#!bin/bash

BASE='/QRISdata/Q1287/MOAGR_RNASeq/00_original_BGI_data/19-04940-57/L2_Pool26_TubeID-19-04940-57-1/'
FILE1='200121_I20_V300046043_L2_Pool26_TubeID-19-04940-57-1_1'
FILE2='200121_I20_V300046043_L2_Pool26_TubeID-19-04940-57-1_2'
OUTPUT='/30days/s4596423/start_outputs_1/'

STAR --runThreadN 12 --runMode alignReads --genomeDir '/QRISdata/Q1287/Minh_envs/reference_mm10/mm10/' --readFilesIn ${BASE}${FILE1}.fq.gz ${BASE}${FILE2}.fq.gz --readFilesCommand zcat --outFileNamePrefix ${OUTPUT}${FILE1}.03. --outSAMtype BAM SortedByCoordinate --outSAMunmapped Within --outFilterMatchNminOverLread 0.3 --outFilterScoreMinOverLread 0.3 --twopassMode Basic --sjdbGTFfile /QRISdata/Q1287/Minh_envs/reference_mm10/gencode.vM24.chr_patch_hapl_scaff.annotation.gtf 75 --quantMode GeneCounts 
