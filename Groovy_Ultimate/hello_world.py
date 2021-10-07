import sys, optparse, os
import pandas as pd
import logging
import subprocess
import duallog
import argparse
from pathlib import Path

if __name__ == '__main__':

    # Count the arguments
    duallog.setup('/Volumes/BiomedML/Projects/QuPath_projects/STRISH_polaris/scripts/logtest')
    open('/Volumes/BiomedML/Projects/QuPath_projects/STRISH_polaris/scripts/file.txt', 'w').close()
    parser = argparse.ArgumentParser(description='Run Hello World Script Rois')
    parser.add_argument('image_folder', type=Path,
                    help='a folder containing tiff files')
    parser.add_argument('--min', type=float,
                        help='minimum normalization value')
    parser.add_argument('--max', type=float,
                        help='max normalization value')
    parser.add_argument('--pc', type=int,
                         help='average cell/nucleus diameter. Highly recommended to set for speed reasons')
    # parser.add_argument('--model', type=str,
    #                     help='cellpose model name')
    args = parser.parse_args()
    with open('/Volumes/BiomedML/Projects/QuPath_projects/STRISH_polaris/scripts/file.txt', 'a+') as file:        

        file.write("\n"+str(args.image_folder))

        file.write("\n"+str(args.min))
        file.write("\n"+str(args.max))
    logging.info(f'Running sklearn PCA with {args.pc}')
    logging.debug('Debug messages are only sent to the logfile.')
    logging.info('Info messages are not shown on the console, too.')
    logging.warning('Warnings appear both on the console and in the logfile.')
    logging.error('Errors get the same treatment.')
    logging.critical('And critical messages, of course.')
    # subprocess.call("python main1.py 'file.txt' 'foldername' ", shell=True)

    print("Done")
