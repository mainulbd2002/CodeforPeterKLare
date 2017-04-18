#/bin/bash

input_file=$1
prop_file=$2
output_file=$3

if ! [ -f "$input_file" ] 
then 
  echo "Input file not found.";
  exit 1;
fi

if ! [ -f "$prop_file" ] 
then 
  echo "Property file not found.";
  exit 1;
fi

if [ -z "$output_file" ]
then
  echo "No output file path supplied."
  exit 1;
fi

dir=$(dirname "$output_file")
mkdir -p -- "$dir"

sed -f <(
   sed '/=/ s/\([^=]*\)=\(.*\)/s#\\\[\\\[\1\\\]\\\]#\2#g/' "$prop_file"
        ) "${input_file}" > ${output_file}
