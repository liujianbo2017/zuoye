/*
 *   Created by zhangboyuan-XD on 2016/5/20.
 *
 *   注意！如果需要显示图片位置的小圆点标识则必须按照demo中的格式书写！
 *   notice! If you need to display a small dot image location identification must be written in accordance with the format of the demo!
 */

window.onload = (function () {
    var banner_container = document.getElementsByClassName('banners-container')[0];  //大banner图片床
    var next = document.getElementsByClassName('next')[0];
    var prev = document.getElementsByClassName('prev')[0];
    var buttons = document.getElementsByClassName('buttons')[0].getElementsByTagName('span');  //小圆点标识

    slideImg(banner_container, next, prev, buttons, 3, 3000, 26);  //参数说明见功能实现↓
});




/**功能实现********************功能实现***********************功能实现********************功能实现*********************功能实现****************************************************/

//参数说明：                                      // Parameter Description:
// container:图片床；                             // Container: your Photos on it;
// btn_next, btn_prev:切换按钮；                  // Btn_next, btn_prev: toggle button(next&prev);
// small_dots：小圆点标识;                        // Small_dots: small dot mark which picture now on focus;
// img_num：图片数量（不包括前后的附图）;           // Img_num: how many pictures you have.(not including the first one and last one figures pictures);
// move_speed:图片移动速度(数值越小越快！);        // Move_speed: image moving speed (the smaller the value, the faster!);
function slideImg(container, btn_next, btn_prev, small_dots, img_num, auto_move_interval, move_speed) {
    var index = 1; //当前图片下小圆点标识  //current picture identification dot
    var img_width = -parseInt(container.style.left); //每张图片宽
    var timer = null;
    var animated = false; //判断是否移动完成  //To determine whether the move is complete
    var active_buttons = false;
    var active_btn_next = false;
    var active_btn_prev = false;
    var active_auto_move = false;

    if (typeof(container) != 'object') {
        alert("图片床参数传入错误！");
        return;
    }
    if (typeof(btn_next) == 'object') active_btn_next = true;
    if (typeof(btn_prev) == 'object') active_btn_prev = true;
    if (typeof (small_dots) == 'object') active_buttons = true;
    if (typeof(img_num) != 'number') {
        alert("parameter \"img_num\" is not right！");
        return;
    }
    if (typeof(auto_move_interval) == 'number') active_auto_move = true;
    if (typeof(move_speed) != 'number') {
        move_speed = 20;
        alert("ERROR:Function \"slideImg()\", parameter \"move_speed\" is not right！已自动修正为20！快谢谢我为你挽救了一切，走上人生巅峰，赢取白富美。哈哈哈哈！ -zby")
    }

    //移动图片床
    function animate(offset) {
        if (offset == 0) {
            return;
        }
        animated = true;
        var auto_move_interval = 10;  //每次移动间隔时间
        var new_left = parseInt(container.style.left) + offset;  //目标图片对应的left值  //Target image corresponding to the left value

        //平滑移动函数
        var move = function () {
            var cur_left = parseInt(container.style.left);    //当前left值
            var move_spacing = (new_left - cur_left) / move_speed;     //移动间隔（逐渐减小，实现平滑移动）//Movement interval (gradually reduced, to achieve a smooth movement)
            move_spacing = move_spacing > 0 ? Math.ceil(move_spacing) : Math.floor(move_spacing); //速度取整
            //当速度大于0且当前left值小于目标left值时，向右移动图片床        // 当速度小于0且当前left值大于目标left值时，向左移动图片床
            if ((move_spacing > 0 && parseInt(container.style.left) < new_left) || (move_spacing < 0 && parseInt(container.style.left) > new_left)) {
                container.style.left = parseInt(container.style.left) + move_spacing + 'px';
                setTimeout(move, auto_move_interval);
            }
            else {
                //移动完成
                container.style.left = new_left + 'px';
                if (new_left > -img_width) {
                    container.style.left = -img_width * img_num + 'px';
                }
                if (new_left < -img_width * img_num) {
                    container.style.left = -1180 + 'px';
                }
                animated = false;
            }
        };
        //入口  //Entrance
        move();
    }


    //右点击，左点击
    btn_next.onclick = (function () {
        if (!active_btn_next) return;

        //判断，如果移动未完成则不进行下一次移动。
        if (animated) {
            return;
        }
        animate(-img_width);
        //小圆点标识更新  //update small dot
        if (index == img_num) index = 1;
        else  index += 1;
        showButton();
    });
    btn_prev.onclick = (function () {
        if (!active_btn_prev) return;

        if (animated) {
            return;
        }
        animate(img_width);
        if (index == 1) index = img_num;
        else  index -= 1;
        index -= 1;
        showButton();
    });


    //点亮，熄灭小圆点
    function showButton() {
        if (!active_buttons) return;

        //熄灭过去圆点
        for (var i = 0; i < small_dots.length; i++) {
            if (small_dots[i].className == 'on') {
                small_dots[i].className = '';
                break;
            }
        }
        //点亮当前小圆点
        small_dots[index - 1].className = 'on';
    }

    //点击小圆点切换图片   //Click the dots to change images
    for (var i = 0; i < small_dots.length; i++) {
        if (!active_buttons) return;

        small_dots[i].onclick = (function () {
            if (this.className == 'on' || animated) return;
            var targetIndex = parseInt(this.getAttribute('index'));
            var offset = -img_width * (targetIndex - index);
            index = targetIndex;
            animate(offset);
            showButton();
        });
    }


    //自动轮播  //auto play
    function play() {
        if (!active_auto_move) return;

        timer = setTimeout(function () {
            if (animated) {
                return;
            }
            animate(-img_width);
            if (index == img_num) index = 1;
            else  index += 1;
            showButton();
            play();
        }, auto_move_interval);
    }

    function stop() {
        clearTimeout(timer);
    }

    //鼠标移入暂停轮播
    container.onmouseover = stop;
    container.onmouseout = play;
    //自动轮播入口 //auto play entrance
    play();
}