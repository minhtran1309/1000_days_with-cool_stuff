folder_dir="$(ls -d GSE139324_RAW/Tonsil/**/**)"
sub_str='genes'
for dir in ${folder_dir};
do 
	echo "$dir";
	fn="${dir##*/}";
	newfn="$(cut -d'_' -f5 <<< ${fn})"
	echo "$newfn";
	if [[ "$newfn" == *"$sub_str"* ]]; 
	then
		newfn='features.tsv.gz'
	fi
	dir_name="$(dirname "${dir}")";
	# echo "$dir_name";
	# echo "$dir";
	echo "${dir_name}/${newfn}"
	mv "$dir" "${dir_name}/${newfn}"
	gunzip -k "$dir"
	echo '--------------------------------------------'
done

# sub_str='features'
# for dir in ${folder_dir};
# do 
# 	echo "$dir";
# 	# fn="${dir##*/}";
# 	# newfn="$(cut -d'_' -f5 <<< ${fn})"
# 	# echo "$newfn";
# 	dir_name="$(dirname "${dir}")";
# 	if [[ "$dir" == *"$sub_str"*.tsv ]]; 
# 	then
# 		newfn='genes.tsv'
# 		mv "$dir" "${dir_name}/${newfn}"
# 	fi

	# echo "$dir_name";
	# echo "$dir";
	# echo "${dir_name}/${newfn}"
	# mv "$dir" "${dir_name}/${newfn}"
	# gunzip -k "$dir"
	echo '--------------------------------------------'
done