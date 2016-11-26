## 开源库
* StaggeredGridView
* SwipeRefreshLayout
* pagerslidingtabstrip
* butterknife
* picasso
* circleimageview

## 技巧
#### 瀑布流
使用瀑布流展示图片时，应在加载图片前确定图片的长宽比。如开源库的StaggeredGridView，就可使用DynamicHeightImageView的setHeightRatio方法，然后再使用Picasso进行图片加载。
DynamicHeightImageView其实只是继承了ImageView，并重写了onMeasure方法，让Height等于测量的Width乘上长宽比。

#### ViewPager和SwipeRefreshLayout手势冲突
在不进行处理时，热门页上面的ViewPager进行滑动时，Touch事件很容易触发SwipeRefreshLayout。
原本所采用的方法是给ViewPager设置onTouchListener，对ViewPager是否已经滑动进行判断。但是发现ViewPager在刚开始滑动时获取到的v.getScrollX没有及时发生变化。于是改为使用PageChangeListener。但这做法与这个ViewPager原本所采用的开源库viewpagerindicator有冲突，因为该开源库的本质还是实现PageChangeListener。
考虑到堆糖热门页的Indicator比较简单，就写了ClumsyIndicator来实现这个效果。

#### 设置布局阴影
原本给布局增加阴影时，采用的是background添加layer_list的方法。但是这种方法会导致视图的过度绘制。于是改为background使用9.png的方法。

#### 热门页滑动图片标题显示
由于各种图片的颜色、亮度不同，白色标题可能存在看不清楚的时候。给ImageView添加ColorFilter，即减少图片的亮度，使标题显示清楚。