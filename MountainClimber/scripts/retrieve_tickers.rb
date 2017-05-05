#! /usr/bin/ruby
# Author: Tyler Manning
# Date: 5/4/2017

# Description: Some basic data parsing to new file from public NASDAQ DB
# Will probably only need to run this once a week to keep an update list of all tickers on the stock exchanges

# TODO: Implement way for HTML parsing / download of the files used to gather data. Implementation might not be in this script

require 'csv'

path = File.join(File.dirname(__FILE__), 'companylist.csv')



## RETRIEVES EVERY STOCK TICKER FROM FILE
col_data = []
CSV.foreach(path, 'r') do |row|
	col_data << row[0]
end
## END

## OUTPUTS EVERY STOCK TICKER TO NEW CSV FILE
CSV.open("tickerlist.csv", "w") do |csv|
	col_data.each do |i|
		next if i == "Symbol"
		temp_array = []
		temp_array[0] = i
		csv << temp_array
	end
end
## END