import csv
import MySQLdb
from connect import connect_to_database

db = connect_to_database();
cur = db.cursor()

print "\n"
print "***Database Connection Closed***"

with open('combined_stock_data.csv','rb') as csvfile:
    for row in csvfile:
        row_array = row.strip().split(",")
        cur.execute("INSERT INTO stock_list VALUES (%s, %s, %s, %s, %s)", (row_array[0], row_array[1], row_array[2], row_array[3], row_array[7]))
        db.autocommit(True)
        print "Query Exectuted"

db.close();
print "*** Database connection closed ***"
