stratioWars
========


Hello fellow rebel! 
Following your instructions, I managed to develop a REST API that will give us the upper hand on this conflict with the Galactic Empire.
I used play framework's rest API and JSON as the input-output format.

Instructions
-------------

This decrypting algorithm accepts input in JSON format as a JSON array of 1 or more sets of coordinates. An example has been provided on resources/death_star_coordinates.json
on the SBT console, type **run** to start the REST server and, after it starts listening, go to the project dir on your command line console and type:

*curl -H "Content-type: application/json" -X POST -d @resources/death_star_coordinates.json http://localhost:9000/decrypt*
 
If the input JSON has the correct format, an output in JSON format will be obtained.
EG: for example input:
>[
>  {
>    "galaxy": "6f9c15fa",
>    "quadrant": "ef51",
>    "starsystem1": "4415",
>    "starsystem2": "afab",
>    "planet": "36218d76c2d9"
>  }
>]

Output will be:
>[{"galaxy":73,"quadrant":15,"starsystem":46,"planet":"dc9876321"}]

---

In case input doesn't have the right format, an error will appear:
EF: for example incorrect input:
>[
>  {
>    "galaxy": "6f9c15fa000",
>    "quadrant": "ef51",
>    "starsystem1": "4415",
>    "starsystem2": "afab",
>    "planet": "36218d76c2d9000"
>  }
>]

Error message will be:
>{"obj[0].galaxy":[{"msg":["galaxy field is not format compliant"],"args":[]}],"obj[0].planet":[{"ms
> g":["planet field is not format compliant"],"args":[]}]}

---


Tests have been included as well. They can be run by typing **test** on the SBT console.





**Good Luck**

![alt text](http://www.azurecurve.co.uk/images/posts/2014/06/Rebel_Alliance/Rebel_Alliance_1.png
 "Join the Alliance!")

