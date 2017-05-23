#! /usr/bin/ruby

# Description: Some basic data parsing to new file from public NASDAQ DB
# Will probably only need to run this once a week to keep an update list of all tickers on the stock exchanges

# TODO: For some reaon the CSV files are formatted differently toward the end!
# THIS LINK https://support.klipfolio.com/hc/en-us/articles/215546368-Use-Yahoo-Finance-as-a-data-source-
# 	WORKS WITH NYSE...for some reason

# Tyler: http://www.alphavantage.co/support/#api-key



require 'net/http'
require 'csv'


output = File.open('output.txt','r')
outputNew = File.open('outputNew.txt','w')

url = ""
counter = 0
output.each do |row|
	filename = "stockdata" + counter.to_s + ".csv"
	`wget -nv -O "#{filename}" "#{row}"`
	sleep 1
	counter = counter + 1
end

puts

#Combine All CSVs here
csv_data = []

CSV.open('combined_stock_data.csv', 'w') do |csv|
	for i in 0..counter-1
		csvfile = "stockdata" + i.to_s + ".csv"
		path = File.join(File.dirname(__FILE__), csvfile)
		CSV.foreach(path) do |row|
			#for each column of information add here
			csv << [row[0],row[1],row[2],row[3],row[4],row[5],row[6],row[7]]		
		end
	end
end




