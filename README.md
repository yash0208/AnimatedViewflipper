# AnimatedViewflipper
Animate View Flipper Using left in and left out animation to provide great ui.


# Use The Library:
implementation 'com.github.bumptech.glide:glide:4.11.0'

# Implementation
 - In  activity_main.xml
 
  <ViewFlipper 
  
      android:layout_width="match_parent"
      android:id="@+id/ViewFlipper"
      android:layout_height="250dp"
      
        </ViewFlipper>
    
 - Add Whatever You Want In The Viewflipper We Will Add Imageview In Relative Layout In That 3 Imageview In 3 Relative Layout.
 i.e
 
 
 
 <RelativeLayout
 
            android:layout_width="match_parent"
            android:layout_height="match_parent">
            
            <ImageView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:padding="5dp"
                android:id="@+id/image1"/>
                
                </RelativeLayout>
  
  In MainActivity.java
  
  - Import:  "import com.bumptech.glide.Glide;"
  
  - Declare Variables
  
  ViewFlipper mViewFlipper;
  
  ImageView Image1,Image2,Image3;
  
  - Get Images From Firebase Using Database Reference And Set Into Imageview Using Glide,i.e:
  
  Glide.with(getApplicationContext()).load(im1).fitCenter().into(Image1);
  
  Glide.with(getApplicationContext()).load(im2).fitCenter().into(Image2);
                   
  Glide.with(getApplicationContext()).load(im3).fitCenter().into(Image3);
  
  - Make Animations 
  1.left_in.xml
  2.left_out.xml
  
  - Add Atributes To ViewFlipper
  
  mViewFlipper.setAutoStart(true);
  
  mViewFlipper.setFlipInterval(4000);
                    
  mViewFlipper.startFlipping();
                    
  mViewFlipper.setInAnimation(MainActivity.this,R.anim.left_in);
                    
  mViewFlipper.setOutAnimation(MainActivity.this,R.anim.left_out);
