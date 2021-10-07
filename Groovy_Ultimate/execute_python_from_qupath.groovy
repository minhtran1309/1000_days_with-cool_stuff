
import java.lang.ProcessBuilder

logger.info( "Running Python Script" )

// The virtualenv from which we will run python.exe
def env_folder = '/Users/uqmtra12/miniconda3/envs/ultimate_env/bin/python'

// The location of the script that will process the images and return RoiSets
def python_file = '/Volumes/BiomedML/Projects/QuPath_projects/STRISH_polaris/scripts/hello_world.py'
def default_param = 'Ahoy'
def num_pc = 50
def lower_val = 0.1
def upper_val = 0.9
def parameters = ["pc":num_pc]
def min_max = ['min': lower_val, 'max': upper_val]
def parameters_strs = parameters.collect{ key, value -> return "--${key}=${value}" }

def pb =  new ProcessBuilder(env_folder, python_file, default_param, '--min='+min_max['min'], 
	'--max='+min_max['max'],*parameters_strs).redirectErrorStream( true )

def process = pb.start()
def sout = new StringBuilder()
logger.info( "Started command: {}", pb.command().join(" "))
process.consumeProcessOutput( sout, sout )
// Show what is happening in the log
while ( process.isAlive() ) {

    if ( sout.size() > 0 ) {
        logger.info( sout.toString() )
        sout.setLength( 0 )
    }

    sleep( 200 )

}

logger.info( "Running Python Script Complete" )

