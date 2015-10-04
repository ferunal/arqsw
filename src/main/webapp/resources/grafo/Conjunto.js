/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Define the dimensions of the visualization. We're using
// a size that's convenient for displaying the graphic on
// http://jsDataV.is




/*= {
 nodes: [
 {name: "Adam"},
 {name: "Bob"},
 {name: "Carrie"},
 {name: "Donovan"},
 {name: "Edward"},
 {name: "Felicity"},
 {name: "George"},
 {name: "Hannah"},
 {name: "Iris"},
 {name: "Jerry"}
 ],
 edges: [
 {source: 0, target: 1},
 {source: 0, target: 2},
 {source: 0, target: 3},
 {source: 0, target: 4},
 {source: 1, target: 5},
 {source: 2, target: 5},
 {source: 2, target: 5},
 {source: 3, target: 4},
 {source: 5, target: 8},
 {source: 5, target: 9},
 {source: 6, target: 7},
 {source: 7, target: 8},
 {source: 8, target: 9}
 ]
 };
 */
//Original data
function calcularGrafo() {


    var dataset;
    d3.json("GenerarJSONSRV", function (json) {
        // Update visualisation here…
        var w = 640;
        var h = 480;

        dataset = json;
//Initialize a default force layout, using the nodes and edges in dataset
        var force = d3.layout.force()
                .nodes(dataset.nodes)
                .links(dataset.edges)
                .size([w, h])
                .linkDistance([140])
                .charge([-100])
                .start();

       // var colors = d3.scale.category10();
//Create SVG element
        var svg = d3.select("#fuerza")
                .append("svg")
                .attr("width", w)
                .attr("height", h);

//Create edges as lines
        var edges = svg.selectAll("line")
                .data(dataset.edges)
                .enter()
                .append("line")
                .style("stroke", "#ccc")
                .style("stroke-width", 3);

//Create nodes as circles
        var nodes = svg.selectAll("circle")
                .data(dataset.nodes)
                .enter()
                .append("circle")
                .attr("r", 15)
                .style("fill",function (d, i) {
                    return d.fondo;
                })
                .call(force.drag);

        nodes.append("svg:title")
                .text(function (d) {
                    return d.name + "\n" + d.desc;
                });
         edges.append("svg:title")
                 .text(function (d) {
                    return d.fuenteOrg;
                });

//Every time the simulation "ticks", this will be called

        force.on("tick", function () {

            edges.attr("x1", function (d) {
                return d.source.x;
            })
                    .attr("y1", function (d) {
                        return d.source.y;
                    })
                    .attr("x2", function (d) {
                        return d.target.x;
                    })
                    .attr("y2", function (d) {
                        return d.target.y;
                    });

            nodes.attr("cx", function (d) {
                return d.x;
            })
                    .attr("cy", function (d) {
                        return d.y;
                    });

        });
        
        console.log("Datos", dataset);
    });
}
/*
$(document).ready(function () {


    //checks for the button click event
    $("#myButton").click(function (e) {

        //get the form data and then serialize that
        dataString = $("#myAjaxRequestForm").serialize();

        //get the form data using another method 
        var countryCode = $("input#countryCode").val();
        dataString = "countryCode=" + countryCode;

        //make the AJAX request, dataType is set to json
        //meaning we are expecting JSON data in response from the server
        $.ajax({
            type: "POST",
            url: "GenerarJSONSRV",
            data: dataString,
            dataType: "json",
            //if received a response from the server
            success: function (data, textStatus, jqXHR) {
                //our country code was correct so we have some information to display
                if (data.success) {
                    $("#ajaxResponse").html("");
                    $("#ajaxResponse").append("<b>Nombre espacio:</b> " + data.name + "");

                }
                //display error message
                else {
                    $("#ajaxResponse").html("<div><b>Country code in Invalid!</b></div>");
                }
            },
            //If there was no resonse from the server
            error: function (jqXHR, textStatus, errorThrown) {
                console.log("Something really bad happened " + textStatus);
                $("#ajaxResponse").html(jqXHR.responseText);
            },
            //capture the request before it was sent to server
            beforeSend: function (jqXHR, settings) {
                //adding some Dummy data to the request
                settings.data += "&dummyData=whatever";
                //disable the button until we get the response
                $('#myButton').attr("disabled", true);
            },
            //this is called after the response or error functions are finsihed
            //so that we can take some action
            complete: function (jqXHR, textStatus) {
                //enable the button 
                $('#myButton').attr("disabled", false);
            }

        });
    });

});
*/

