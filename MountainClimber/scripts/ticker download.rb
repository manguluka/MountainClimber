#! /usr/bin/ruby

# Description: Some basic data parsing to new file from public NASDAQ DB
# Will probably only need to run this once a week to keep an update list of all tickers on the stock exchanges

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

output.each do |row|
	`wget -O "test.csv" "#{row}"`
end

