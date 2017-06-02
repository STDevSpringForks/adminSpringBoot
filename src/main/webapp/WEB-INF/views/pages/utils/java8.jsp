<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src='https://api.tiles.mapbox.com/mapbox-gl-js/v0.37.0/mapbox-gl.js'></script>
<link href='https://api.tiles.mapbox.com/mapbox-gl-js/v0.37.0/mapbox-gl.css' rel='stylesheet' />
<style>
     body { margin:0; padding:0; }
     #map { position:absolute; top:0; bottom:0; width:100%; }
</style>
<div id='map'></div>
<script>
mapboxgl.accessToken = 'pk.eyJ1IjoiY204NTAxMDEiLCJhIjoiY2ozYWJnNzA1MDBvNTJ3bnpuc2JtNmR0ciJ9.thcRoF9Fj21hiXTqMa1F9Q';
var map = new mapboxgl.Map({
    container: 'map',
    style: 'mapbox://styles/mapbox/light-v9',
    zoom: 12,
    center: [-122.447303, 37.753574]
});

map.on('load', function () {

    map.addLayer({
        'id': 'population',
        'type': 'circle',
        'source': {
            type: 'vector',
            url: 'mapbox://examples.8fgz4egr'
        },
        'source-layer': 'sf2010',
        'paint': {
            // make circles larger as the user zooms from z12 to z22
            'circle-radius': {
                'base': 1.75,
                'stops': [[12, 2], [22, 180]]
            },
            // color circles by ethnicity, using data-driven styles
            'circle-color': {
                property: 'ethnicity',
                type: 'categorical',
                stops: [
                    ['White', '#fbb03b'],
                    ['Black', '#223b53'],
                    ['Hispanic', '#e55e5e'],
                    ['Asian', '#3bb2d0'],
                    ['Other', '#ccc']]
            }
        }
    });
});
</script>