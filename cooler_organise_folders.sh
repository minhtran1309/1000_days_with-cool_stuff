folder_dir="/QRISdata/Q1851/Minh/Stanford/All_Batches/*"
mcd_str=".mcd"
txt_str=".txt"
for dir in ls $folder_dir;
do 
	#echo "$dir";
	#echo "$newfn";
	if [[ "$dir" == *"$mcd_str" ]]; 
	then
		newdir="${dir%.mcd}"
		dir_name="$(dirname "${dir}")";
		echo "$dir"
		echo "$newdir"
		mkdir "${newdir}"
		mv "$dir" "$newdir"
		echo "-------------"		
	elif [[ "$dir" == *"$txt_str"  ]];
	then
		fn="${dir##*/}";
		dir_name="$(dirname "${dir}")";
		newfn="$(cut -d'_' -f1 <<< ${fn})"
		newfn="${newfn%.txt}"
		echo "$dir"
		echo "$dir_name/$newfn";
		mv "${dir}" "${dir_name}"/"${newfn}"
		echo "-------------"
	fi

	# dir_name="$(dirname "${dir}")";
	# echo "$dir_name";
	# echo "$dir";
	# echo "${dir_name}/${newfn}"
#	mv "$dir" "${dir_name}/${newfn}"
#	gunzip -k "$dir"
#	echo '--------------------------------------------'
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
#	echo '--------------------------------------------'
#done
