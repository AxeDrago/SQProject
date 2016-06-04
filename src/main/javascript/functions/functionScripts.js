/**
 * Created by Clifton on 31/5/16.
 */
function memberPageArray(arr){
    
    var name =  arr[0].name;
    var country = arr[0].country;
    var address = arr[0].address;
    var contacts = arr[0].contacts;
    var cv = arr[0].cv;
    var skills = arr[0].skills;
    var socialMedia = arr[0].social_media_link;
    var profExp = arr[0].professional_exp;

    document.getElementById("name").innerHTML = name;
    document.getElementById("country").innerHTML = country;
    document.getElementById("address").innerHTML = address;
    document.getElementById("contacts").innerHTML = contacts;
    document.getElementById("cv").innerHTML = cv;
    document.getElementById("skills").innerHTML = skills;
    document.getElementById("socialM").innerHTML = socialMedia;
    document.getElementById("profExp").innerHTML = profExp;

}

