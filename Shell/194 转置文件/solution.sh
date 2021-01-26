awk '{
    for (i=1;i<=NF;i++){
        if (NR==1) res[i]=$i
        else res[i]=res[i]" "$i
    }
} END {
    for(j=1;j<=NF;j++) print res[j]
}' file.txt
## NF 文件总行数
## NR 当前行数 从一开始
