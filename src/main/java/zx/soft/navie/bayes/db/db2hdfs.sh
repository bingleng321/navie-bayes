for i in cat tablenames;
    do
        echo $i;
	hadoop jar navie-bayes-jar-with-dependencies.jar dbRecordPretreatmentToHDFS -D tablename=$i -D processData=weibo-data/$i
    done;