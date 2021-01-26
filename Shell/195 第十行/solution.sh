# Read from the file file.txt and output the tenth line to stdout.
row=$(awk '{print NR}' file.txt | tail -n1)
if [ $row -lt 10 ]; then
    echo "The file is less than 10 row"
else
    awk '{
        if (NR==10) print $0
    }' file.txt
fi
