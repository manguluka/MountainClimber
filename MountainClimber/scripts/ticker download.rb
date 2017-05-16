#! /usr/bin/ruby

# Description: Some basic data parsing to new file from public NASDAQ DB
# Will probably only need to run this once a week to keep an update list of all tickers on the stock exchanges

require "open-uri"
output = File.open('output.txt','r')
outputNew = File.open('outputNew.txt','r')


output.each do |row|
	uri = URI.parse(row.chomp)
 	contents = open(uri,{ssl_verify_mode: OpenSSL::SSL::VERIFY_NONE}) { |f| f.read}
	outputNew << contents
end
