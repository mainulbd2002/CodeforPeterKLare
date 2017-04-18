#Creating script to replace HTML placeholders


prop=$1
in_file=$2
out_file=$3

if ! [ -f "$in_file" ]
then
	echo "Cannot find input";
	exit 1;
fi


if ! [ -f "$prop" ]
then
	echo "Cannot find properties file";
	exit 1;
fi

if [ -z "out_file" ]
then
	echo "Out file is not specified;
	exit 1;
fi

direcotry=$(dirname "$out_file")
mkdir -p -- "$directory"

sed -f <(sed '/=/ s/\([^=]*\)=\(.*\)/s#\\\[\\\[\1\\\]\\\]#\2#g/' "$prop") "${in_file}" > ${out_file}

	

