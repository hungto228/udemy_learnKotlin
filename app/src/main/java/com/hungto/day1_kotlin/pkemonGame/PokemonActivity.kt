package com.hungto.day1_kotlin.pkemonGame

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.hungto.day1_kotlin.R

class PokemonActivity : AppCompatActivity(), OnMapReadyCallback {
    private  var mMap: GoogleMap?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.pokemon) as SupportMapFragment
        mapFragment.getMapAsync(this)
        checkPermmison()
        LoadPockemon()

    }

    var ACCESSLOCATION=123
    fun checkPermmison(){

        if(Build.VERSION.SDK_INT>=23){

            if(ActivityCompat.
                checkSelfPermission(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){

                requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),ACCESSLOCATION)
                return
            }
        }

        GetUserLocation()
    }

    fun GetUserLocation(){
        Toast.makeText(this,"User location access on",Toast.LENGTH_LONG).show()
        //TODO: Will implement later

        var myLocation= MylocationListener()

        var locationManager=getSystemService(Context.LOCATION_SERVICE) as LocationManager

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,3,3f,myLocation)

        var mythread=myThread()
        mythread.start()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        when(requestCode){

            ACCESSLOCATION->{

                if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    GetUserLocation()
                }else{
                    Toast.makeText(this,"We cannot access to your location",Toast.LENGTH_LONG).show()
                }
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap


    }

    var location:Location?=null

    //Get user location

    inner class MylocationListener:LocationListener{


        constructor(){
            location= Location("Start")
            location!!.longitude=0.0
            location!!.longitude=0.0
        }
        override fun onLocationChanged(p0: Location) {
            location=p0
        }



    }


    var oldLocation:Location?=null
    inner class myThread:Thread{

        constructor():super(){
            oldLocation= Location("Start")
            oldLocation!!.longitude=0.0
            oldLocation!!.longitude=0.0
        }

        override fun run(){

            while (true){

                try {

                    if(oldLocation!!.distanceTo(location)==0f){
                        continue
                    }

                    oldLocation=location


                    runOnUiThread {


                        mMap!!.clear()

                        // show me
                        val sydney = LatLng(location!!.latitude, location!!.longitude)
                        mMap!!.addMarker(MarkerOptions()
                            .position(sydney)
                            .title("Me")
                            .snippet(" here is my location")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.mario)))
                        mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 14f))

                        // show pockemons

                        for(i in 0..listPockemons.size-1){

                            var newPockemon=listPockemons[i]

                            if(newPockemon.isCatch==false){

                                val pockemonLoc = LatLng(newPockemon.location!!.latitude, newPockemon.location!!.longitude)
                                mMap!!.addMarker(MarkerOptions()
                                    .position(pockemonLoc)
                                    .title(newPockemon.name!!)
                                    .snippet(newPockemon.desc!! +", power:"+ newPockemon!!.power)
                                    .icon(BitmapDescriptorFactory.fromResource(newPockemon.image!!)))


                                if (location!!.distanceTo(newPockemon.location)<2){
                                    newPockemon.isCatch=true
                                    listPockemons[i]=newPockemon
                                    playerPower+=newPockemon.power!!
                                    Toast.makeText(applicationContext,
                                        "You catch new pockemon your new pwoer is " + playerPower,
                                        Toast.LENGTH_LONG).show()

                                }

                            }
                        }





                    }

                    Thread.sleep(1000)

                }catch (ex:Exception){}


            }

        }

    }


    var playerPower=0.0
    var listPockemons=ArrayList<PokemonModel>()

    fun  LoadPockemon(){


        listPockemons.add(PokemonModel(R.drawable.charmander,
            "Charmander", "Charmander living in japan", 55.0, 37.7789994893035, -122.401846647263))
        listPockemons.add(PokemonModel(R.drawable.bulbasaur,
            "Bulbasaur", "Bulbasaur living in usa", 90.5, 37.7949568502667, -122.410494089127))
        listPockemons.add(PokemonModel(R.drawable.squirtle,
            "Squirtle", "Squirtle living in iraq", 33.5, 37.7816621152613, -122.41225361824))

    }

}

