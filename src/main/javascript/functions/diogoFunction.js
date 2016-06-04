/**
 * Created by Diogo on 04/06/2016.
 */

var s = '[{ "name": "Diogo Lopes", "profession": "Software Engineer", "country": "Portugal", "teamName": "Team DCM", "email": "diogomartins5@hotmail.com || diogomartins9@gmail.com", "github": "Github", "twitter": "Twitter", "cv": "Download CV", "educationInfromation": [ {"areaName": "Education History", "year": "2012", "school":"Instituto Politécnico de Leiria", "course": "Computer Engineering", "duration": "2012-2015", "location": "Leiria", "level": "Bachelor Degree"}], "skillsInformation": [{"areaName":"Programming Skills"}, {"name":"Java", "percentage":"80%"}, {"name":"HTML", "percentage":"70%"}, {"name":"CSS", "percentage":"75%"}, {"name":"PHP", "percentage":"65%"}, {"name":"mySQL", "percentage":"75%"}], "languageInformation": [{"areaName":"Language Skills"}, {"name":"Portuguese", "type":"Native"}, {"name":"English", "type":"Fluent"}]}]';

var jsonData = JSON.parse(s);

document.getElementById("name").innerHTML = jsonData[0].name;
document.getElementById("profession").innerHTML = jsonData[0].profession;
document.getElementById("country").innerHTML = jsonData[0].country;
document.getElementById("teamHome").innerHTML = jsonData[0].teamName;
document.getElementById("email").innerHTML = jsonData[0].email;
document.getElementById("github").innerHTML = jsonData[0].github;
document.getElementById("twitter").innerHTML = jsonData[0].twitter;
document.getElementById("cv").innerHTML = jsonData[0].cv;

document.getElementById("edu_history").innerHTML = jsonData[0].educationInfromation[0].areaName;
document.getElementById("year").innerHTML = jsonData[0].educationInfromation[0].year;
document.getElementById("school").innerHTML = jsonData[0].educationInfromation[0].school;
document.getElementById("course").innerHTML = jsonData[0].educationInfromation[0].course;
document.getElementById("duration").innerHTML = jsonData[0].educationInfromation[0].duration;
document.getElementById("location").innerHTML = jsonData[0].educationInfromation[0].location;
document.getElementById("level").innerHTML = jsonData[0].educationInfromation[0].level;

document.getElementById("programmingSkills").innerHTML = jsonData[0].skillsInformation[0].areaName;
document.getElementById("skill").innerHTML = jsonData[0].skillsInformation[1].name;
document.getElementById("percentage").innerHTML = jsonData[0].skillsInformation[1].percentage;
document.getElementById("skill1").innerHTML = jsonData[0].skillsInformation[2].name;
document.getElementById("percentage1").innerHTML = jsonData[0].skillsInformation[2].percentage;
document.getElementById("skill2").innerHTML = jsonData[0].skillsInformation[3].name;
document.getElementById("percentage2").innerHTML = jsonData[0].skillsInformation[3].percentage;
document.getElementById("skill3").innerHTML = jsonData[0].skillsInformation[4].name;
document.getElementById("percentage3").innerHTML = jsonData[0].skillsInformation[4].percentage;
document.getElementById("skill4").innerHTML = jsonData[0].skillsInformation[5].name;
document.getElementById("percentage4").innerHTML = jsonData[0].skillsInformation[5].percentage;


document.getElementById("languageSkills").innerHTML = jsonData[0].languageInformation[0].areaName;
document.getElementById("languageLevel").innerHTML = jsonData[0].languageInformation[1].type;
document.getElementById("language").innerHTML = jsonData[0].languageInformation[1].name;
document.getElementById("languageLevel1").innerHTML = jsonData[0].languageInformation[2].type;
document.getElementById("language1").innerHTML = jsonData[0].languageInformation[2].name;





