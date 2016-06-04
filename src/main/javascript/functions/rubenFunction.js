var s =
'[{"name": "Rúben Maia","profession": "Software Engineer","country": "Leiria, Portugal","teamName": "Team DCM","email": "maia.ruben@gmail.com","github": "@rbnmaia","twitter": "@ruben_maia","linkedin": " linkedin.com/in/rubenmaia","workInformation":[{"areaName": "Work History","year": "2010","role": "Technical Support","duration": "01/2010-04/2010","location": "Leiria","company": "Instituto Politécnico de Leiria","description": "DEI - Technical Support"}],"educationInformation": [{"areaName": "Education History","year": "2015","course": "BSc., Computer Engineering","duration": "2010-2015","location": "Leiria, Portugal","description": "Bachelor Degree"}],"skillsInformation": [{"areaName":"Programming Skills"},{"name":"HTML", "percentage":"100%"},{"name":"CSS", "percentage":"80%"},{"name":"PHP", "percentage":"75%"},{"name":"ASP.NET", "percentage":"90%"}],"languageInformation": [{"areaName":"Language Skills"},{"name":"Portuguese", "type":"Native"},{"name":"English", "type":"Fluent"},{"name":"French", "type":"Basic"}]}]';

var jsonData = JSON.parse(s);

document.getElementById("name").innerHTML = jsonData[0].name;
document.getElementById("profession").innerHTML = jsonData[0].profession;
document.getElementById("country").innerHTML = jsonData[0].country;
document.getElementById("teamHome").innerHTML = jsonData[0].teamName;
document.getElementById("email").innerHTML = jsonData[0].email;
document.getElementById("github").innerHTML = jsonData[0].github;
document.getElementById("twitter").innerHTML = jsonData[0].twitter;
document.getElementById("linkedin").innerHTML = jsonData[0].linkedin;


document.getElementById("work_history").innerHTML = jsonData[0].workInformation[0].areaName;
document.getElementById("year").innerHTML = jsonData[0].workInformation[0].year;
document.getElementById("company").innerHTML = jsonData[0].workInformation[0].company;
document.getElementById("role").innerHTML = jsonData[0].workInformation[0].role;
document.getElementById("duration").innerHTML = jsonData[0].workInformation[0].duration;
document.getElementById("location").innerHTML = jsonData[0].workInformation[0].location;
document.getElementById("description").innerHTML = jsonData[0].workInformation[0].description;

document.getElementById("edu_history").innerHTML = jsonData[0].educationInformation[0].areaName;
document.getElementById("year").innerHTML = jsonData[0].educationInformation[0].year;
document.getElementById("school").innerHTML = jsonData[0].educationInformation[0].school;
document.getElementById("course").innerHTML = jsonData[0].educationInformation[0].course;
document.getElementById("duration").innerHTML = jsonData[0].educationInformation[0].duration;
document.getElementById("location").innerHTML = jsonData[0].educationInformation[0].location;
document.getElementById("level").innerHTML = jsonData[0].educationInformation[0].level;

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
document.getElementById("languageLevel1").innerHTML = jsonData[0].languageInformation[3].type;
document.getElementById("language1").innerHTML = jsonData[0].languageInformation[3].name;