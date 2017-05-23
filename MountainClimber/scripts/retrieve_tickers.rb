#! /usr/bin/ruby

# Description: Some basic data parsing to new file from public NASDAQ DB
# Will probably only need to run this once a week to keep an update list of all tickers on the stock exchanges

# TODO: Implement way for HTML parsing / download of the files used to gather data. Implementation might not be in this script



require 'csv'
output = File.open('output.txt', "w")
path = File.join(File.dirname(__FILE__), 'NASDAQ.csv')


## RETRIEVES EVERY STOCK TICKER FROM FILE
col_data = []
counter = 0
CSV.foreach(path, 'r') do |row|
	next if row[0] == "Symbol"
	col_data << row[0]
end

path = File.join(File.dirname(__FILE__), 'nyse.csv')

CSV.foreach(path, 'r') do |row|
 	next if row[0] == "Symbol"
 	col_data << row[0]
end

size = col_data.size

#yql_query = "http://finance.yahoo.com/d/quotes.csv?s="
yql_query = "http://download.finance.yahoo.com/d/quotes.csv?s="
until size <= 0
	for j in 0..99
		if j == 99
			yql_query << col_data[counter].to_s + "&f=sl1d1t1c1ohgv&e=.csv&columns='symbol,price,date,time,change,col1,high,low,col2"
			counter = counter + 1
		elsif counter == col_data.size-1
			yql_query << col_data[counter].to_s + "&f=sl1d1t1c1ohgv&e=.csv&columns='symbol,price,date,time,change,col1,high,low,col2"
			break
		else
			yql_query << col_data[counter].to_s + ","
			counter = counter + 1
		end
	end 
	size = size - 100
	output.puts yql_query 
	yql_query = "http://finance.yahoo.com/d/quotes.csv?s="	
end

puts "Download of Files..Complete!"




