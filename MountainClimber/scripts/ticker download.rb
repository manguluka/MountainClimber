#! /usr/bin/ruby

# Description: Some basic data parsing to new file from public NASDAQ DB
# Will probably only need to run this once a week to keep an update list of all tickers on the stock exchanges

# TODO: For some reaon the CSV files are formatted differently toward the end!
# THIS LINK https://support.klipfolio.com/hc/en-us/articles/215546368-Use-Yahoo-Finance-as-a-data-source-
# 	WORKS WITH NYSE...for some reason

# Tyler: http://www.alphavantage.co/support/#api-key

require 'net/http'
require 'open-uri'
require 'openssl'
output = File.open('output.txt','r')
outputNew = File.open('outputNew.txt','w')


# output.each do |row|
# 	uri = URI(row)
# 	http = Net::HTTP.new(uri.host, uri.port)
# 	http.use_ssl = true
# 	http.verify_mode = OpenSSL::SSL::VERIFY_NONE
# 	request = Net::HTTP::Get.new(uri.request_uri)
# 	response = http.request(request)
# 	outputNew << response
# end

url = ""
counter = 0
output.each do |row|
	filename = "test" + counter.to_s + ".csv"
	`wget -O "#{filename}" "#{row}"`
	counter = counter + 1
	sleep 1
end

