import MySQLdb

def connect_to_database():
    try:
        db = MySQLdb.connect(host="localhost",    # your host, usually localhost
                             user="root",         # your username
                             passwd="",           # your password
                             db="javabase")       # name of the data base

        print "Database Connected!"

        
        return db


        
    except:
        print "***ERROR: Database cannot connect***\n"





