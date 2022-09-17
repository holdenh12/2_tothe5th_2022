require 'uri'
require 'net/http'
require 'json'
=begin
cerner_2tothe5th_2022
cerner_2^5th_2022

Day 3: simple GET request and parsing of data to display the top ten of the current F1 standings.

Program output: 
    
        2022 Driver Standings as of Round 16

    Pos     Driver        Code   Pts   Wins     Constructor
    1     M. Verstappen   VER    335    11 		 Red Bull            
    2     C. Leclerc      LEC    219     3 		 Ferrari             
    3     S. Pérez        PER    210     1 		 Red Bull            
    4     G. Russell      RUS    203     0 		 Mercedes            
    5     C. Sainz        SAI    187     1 		 Ferrari             
    6     L. Hamilton     HAM    168     0 		 Mercedes            
    7     L. Norris       NOR     88     0 		 McLaren             
    8     E. Ocon         OCO     66     0 		 Alpine F1 Team      
    9     F. Alonso       ALO     59     0 		 Alpine F1 Team      
    10    V. Bottas       BOT     46     0 		 Alfa Romeo  
    
=end

uri = URI('http://ergast.com/api/f1/current/driverStandings.json')
res = Net::HTTP.get_response(uri)

if res.is_a?(Net::HTTPSuccess) 
    #parse JSON
    jsonRes = JSON.parse(res.body) 
    currentSeason = jsonRes['MRData']['StandingsTable']['season']
    currentRound = jsonRes['MRData']['StandingsTable']['StandingsLists'][0]['round']
    driverStandings = jsonRes['MRData']['StandingsTable']['StandingsLists'][0]['DriverStandings']

    #format and print results.
    puts "#{currentSeason} Driver Standings as of Round #{currentRound}\n\n"
    printf "%-3s %10s %11s %5s %6s %15s\n", "Pos", "Driver", "Code", "Pts", "Wins", "Constructor"
    for pos in 0..9 do
        driver = driverStandings[pos]
        printf "%-5s %-15s %-6s %3s %5s \t\t %-20s\n", driver['position'], driver['Driver']['givenName'][0] +". " +
            driver['Driver']['familyName'], driver['Driver']['code'], driver['points'], driver['wins'], driver['Constructors'][0]['name']
    end
else 
    puts 'Sorry bad HTTP Request'
end