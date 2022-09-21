const http = require('http');
/*
  cerner_2tothe5th_2022
  cerner_2^5_2022

  Day 7: Thought I would take it back to the F1 data and show the current constructor standings after 16 rounds.
      Oracle Red Bull with their drivers Max and Sergio are putting in some work this season! (Driver Standings can be found in the Day 3 Submission.)

  Program Output:

            2022 Constructor Standings           Round. 16
    --------------------------------------------------------------
    Pos.      Team                   Natl.      Points    Wins   |
    1.      Red Bull               Austrian       545       12   |
    2.      Ferrari                Italian        406       4    |
    3.      Mercedes               German         371       0    |
    4.      Alpine F1 Team         French         125       0    |
    5.      McLaren                British        107       0    |
    6.      Alfa Romeo             Swiss          52        0    |
    7.      Haas F1 Team           American       34        0    |
    8.      AlphaTauri             Italian        33        0    |
    9.      Aston Martin           British        25        0    |
    10.     Williams               British        6         0    |
    --------------------------------------------------------------
*/

// Make GET call to F1 API
http.get('http://ergast.com/api/f1/current/constructorStandings.json', res => {
  let data = [];
  const headerDate = res.headers && res.headers.date ? res.headers.date : 'no response date';
  console.log('Status Code:', res.statusCode);
  console.log('Date in Response header:', headerDate);

  // Append data to storage array
  res.on('data', chunk => {
    data.push(chunk);
  });

  // Parse through recieved data.
  res.on('end', () => {
    console.log('Response ended. . .\n');
    const resData =JSON.parse(Buffer.concat(data).toString());
    const constructorStandings = resData.MRData.StandingsTable.StandingsLists[0].ConstructorStandings;

    // Format and print JSON data into nice table.
    console.log(`2022 Constructor Standings`.padStart(30) + `Round. 16`.padStart(20) + "\n--------------------------------------------------------------");
    console.log(`Pos.`.padEnd(10) + `Team`.padEnd(21) + `  Natl.`.padEnd(13) + `Points`.padEnd(10) + `Wins`.padEnd(7) + `|`);
    for (let i = 0; i < 10; i++) {
      const constPosData = constructorStandings[i]
      const constructor = constPosData.Constructor;
      console.log(`${i+1}.`.padEnd(8) + `${constructor.name}`.padEnd(23) + `${constructor.nationality}`.padEnd(15) + `${constPosData.points}`.padEnd(10) + `${constPosData.wins}`.padEnd(5) + `|`);
    }
    console.log("--------------------------------------------------------------")
  });

// Handle bad requests
}).on('error', err => {
  console.log('Bad Request to API... Sorry..: ', err.message);
});