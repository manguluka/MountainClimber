import MySQLdb

def connect_to_database():
    try:
        db = MySQLdb.connect(host="localhost",    # your host, usually localhost
                             user="root",         # your username
                             passwd="",           # your password
                             db="javabase")       # name of the data base

        print "Database Connected!"

        cur = db.cursor()
        cur.execute("SELECT * FROM test")

        for row in cur.fetchall():
            print row[0]

        db.close()

        
    except:
        print "***ERROR: Database cannot connect***\n"

    finally:
        print "Session Closed."




