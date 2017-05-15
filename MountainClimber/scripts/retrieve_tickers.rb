#! /usr/bin/ruby
# Author: Tyler Manning//////////
# Date: 5/4/2017

# Description: Some basic data parsing to new file from public NASDAQ DB
# Will probably only need to run this once a week to keep an update list of all tickers on the stock exchanges

# TODO: Implement way for HTML parsing / download of the files used to gather data. Implementation might not be in this script

require 'csv'

path = File.join(File.dirname(__FILE__), 'companylist.csv')


## RETRIEVES EVERY STOCK TICKER FROM FILE
col_data = []
counter = 0
CSV.foreach(path, 'r') do |row|
	#yql << "\"" + row[0] +"\"\,"
	next if row[0] == "Symbol"
	col_data << row[0]
end

#path = File.join(File.dirname(__FILE__), 'nyse.csv')

# CSV.foreach(path, 'r') do |row|
# 	#yql << "\"" + row[0] +"\"\,"
# 	next if row[0] == "Symbol"
# 	col_data << row[0]
# end

size = col_data.size

yql_array = []
yql_query = "finance.yahoo.com/d/quotes.csv?s="
until size <= 0
	for j in 0..199
		if j == 199
			yql_query << col_data[counter].to_s + "&f=snab"
			counter = counter + 1
		elsif counter == col_data.size-1
			yql_query << col_data[counter].to_s + "&f=nab"
			break
		else
			yql_query << col_data[counter].to_s + "+"
			counter = counter + 1
		end
	end 
	size = size - 200
	puts yql_query   
	yql_query = "finance.yahoo.com/d/quotes.csv?s="	
end




## OUTPUTS EVERY STOCK TICKER TO NEW CSV FILE
# CSV.open("tickerlist.csv", "w") do |csv|
# 	col_data.each do |i|
# 		next if i == "Symbol"
# 		temp_array = []
# 		temp_array[0] = i
# 		csv << temp_array
# 	end
# end
# END