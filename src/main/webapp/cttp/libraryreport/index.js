$(function () {
    getBookLendByAcademy();
    getResourceCountBy_year();//历年馆藏资源统计
    getCollectionOverall();
    getCollectionNewAdded();
    getCollectionNewAddedByCate();
    getCollectionTuShuNewAddedByCate();
    getCollectionWaiWenNewAddedByCate();
    getGctrlsCountBy_year();//历年进馆统计
    getGctrlsCountBy_month();//图书馆门禁按月进馆统计
    getmankindGctrl_Byoneyear();//进馆读者类型比例图
    getmankindCount_Byyear();//进馆读者类型趋势图
    getBook_LendCountBy_year();//历年图书借还总次数
    getBookkindAllCount_Byyear();//读者借阅分类
    getBook_LendCountBy_academyAndyear();//学院借阅
    getbooklendPeopleAndCount_Byhour();//各时段平均借出册数，人数
    getlend_student_type();//各类型读者借阅比例图
    getlendrenew_student_type();//各类型读者续借比例图
    geICdurationCountBy_year();//电子阅览室使用统计
    geICdurationBy_year();//座位在座时长
    geteread_hour();//电子阅览室各时段平均使用次数
    getprintsCountBy_year();//历年文印总量
    getprinttimesCountBy_year();//历年打印次数
    getcopytimesCountBy_year();//历年复印次数
    getscantimesCountBy_year();//历年扫描次数
    getprints_hour();//自助文印各时段平均
    readerLend();//读者借阅排名
    bookLend1();//图书借阅排名按册
    bookLend2(); //图书借阅排名按种
    bookLend3();// 最受欢迎的前100本图书   小章定义
    staffLend(); //教职工借阅册数分类
    getpublish_raking();//借阅出版社排名
    getpublish_rating();//借阅出版社比例
    day_gctrl();//当年每日进馆
    dctrl_top12();//排名前12
    getCollectionByPubyear();//图书按出版年份统计表（种/ 册）
    //getYearTop3CategoryByAcademy();
    $.ajax({
        type:"get",
        contentType: 'application/json',
        url:"../../schoolReport/getICTimesBYTypeOneyear",
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            month=data.month;
            ereadtimesg=data.ereadtimesg;
            ereadtimeso=data.ereadtimeso;
            ereadtimest=data.ereadtimest;
            ereadtimesu=data.ereadtimesu;
            seattimesg=data.seattimesg;
            seattimeso=data.seattimeso;
            seattimest=data.seattimest;
            seattimesu=data.seattimesu;
            croomtimesg=data.croomtimesg;
            croomtimeso=data.croomtimeso;
            croomtimest=data.croomtimest;
            croomtimesu=data.croomtimesu;
            equipmenttimesg=data.equipmenttimesg;
            equipmenttimeso=data.equipmenttimeso;
            equipmenttimest=data.equipmenttimest;
            equipmenttimesu=data.equipmenttimesu;
            for(var i=0;i<month.length;i++){
                amounteread[i]=Number(ereadtimesg[i])+Number(ereadtimeso[i])+Number(ereadtimest[i])+Number(ereadtimesu[i]);
                amountcroom[i]=Number(croomtimesg[i])+Number(croomtimeso[i])+Number(croomtimest[i])+Number(croomtimesu[i]);
                amountseat[i]=Number(seattimesg[i])+Number(seattimeso[i])+Number(seattimest[i])+Number(seattimesu[i]);
                amountequipment[i]=Number(equipmenttimesg[i])+Number(equipmenttimeso[i])+Number(equipmenttimest[i])+Number(equipmenttimesu[i]);
            }
        }
    });
    croomchart("croom");
    ereadchart("eread");
    seatchart("seat");
    equipmentchart("equipment");
    getCollectionAmountType();
    getCollectionByStackAndBooktype();
    getCollectionBycategory();
    getTop10category();
});
var month;
var ereadtimesg;
var ereadtimeso;
var ereadtimest;
var ereadtimesu;
var seattimesg;
var seattimeso;
var seattimest;
var seattimesu;
var croomtimesg;
var croomtimeso;
var croomtimest;
var croomtimesu;
var equipmenttimesg;
var equipmenttimeso;
var equipmenttimest;
var equipmenttimesu;
var amounteread=[];
var amountcroom=[];
var amountseat=[];
var amountequipment=[];
function croomchart(chartid){
    var croom_count = echarts.init(document.getElementById(chartid));
    var  croom_count_option ={
        /*backgroundColor: "#344b58",*/
        animation:false,
        "tooltip": {
            "trigger": "axis",
            "axisPointer": {
                "type": "shadow",
                textStyle: {
                    color: "#222"
                }

            },
        },
        /*"grid": {
         "borderWidth": 0,
         "top": 110,
         "bottom": 95,
         textStyle: {
         color: "#222"
         }
         },*/
        "legend": {
            /*right: '10%',*/
            /*top: '11%',*/
            textStyle: {
                color: '#90979c',
            },
            "data": ['本科生', '研究生','教师','其他']
        },


        "calculable": true,
        "xAxis": [{
            "name":"时间",
            "type": "category",
            "axisLine": {
                lineStyle: {
                    color: '#222'
                }
            },
            "splitLine": {
                "show": false
            },
            "axisTick": {
                "show": false
            },
            "axisLabel": {
                rotate:40,
                "interval": 0,

            },
            "data": month,
        }],
        "yAxis": [{
            "name":"人次",
            "type": "value",
            "splitLine": {
                "show": false
            },
            "axisLine": {
                lineStyle: {
                    color: '#222'
                }
            },
            "axisTick": {
                "show": false
            },
            "axisLabel": {
                "interval": 0,

            },
            "splitArea": {
                "show": false
            },

        }],
        /*dataZoom: [{
         type: 'inside',
         start: 70,
         end: 100
         }, {
         start: 70,
         end: 100,
         handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
         handleSize: '80%',
         handleStyle: {
         color: '#fff',
         shadowBlur: 3,
         shadowColor: 'rgba(0, 0, 0, 0.6)',
         shadowOffsetX: 2,
         shadowOffsetY: 2
         }
         }],*/
        "series": [{
            "name": "本科生",
            "type": "bar",
            "stack": "总量",
            "barMaxWidth": 35,
            "barGap": "10%",
            "itemStyle": {
                "normal": {
                    "color": "rgba(255,144,128,1)",
                    "label": {
                        "show": false,
                        "textStyle": {
                            "color": "#fff"
                        },
                        "position": "insideTop",
                        formatter: function(p) {
                            return p.value > 0 ? (p.value) : '';
                        }
                    }
                }
            },
            "data": croomtimesu,
        },

            {
                "name": "研究生",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(0,191,183,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": croomtimesg
            },
            {
                "name": "教师",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(30,144,255,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": croomtimest
            },{
                "name": "其他",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(255,165,0,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": croomtimeso
            },{
                "name": "总数",
                "type": "line",
                "stack": "总量",
                symbolSize:10,
                symbol:'circle',
                "itemStyle": {
                    "normal": {
                        "color": "rgba(30,144,255,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": true,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data":amountcroom
            },
        ]
    };
    croom_count.setOption(croom_count_option);
}
function ereadchart(chartid){
    var eread_count = echarts.init(document.getElementById(chartid));
    var  eread_count_option ={
        /*backgroundColor: "#344b58",*/
        animation:false,
        "tooltip": {
            "trigger": "axis",
            "axisPointer": {
                "type": "shadow",
                textStyle: {
                    color: "#222"
                }

            },
        },
        /*"grid": {
         "borderWidth": 0,
         "top": 110,
         "bottom": 95,
         textStyle: {
         color: "#fff"
         }
         },*/
        "legend": {
            /*right: '10%',*/
            /*top: '11%',*/
            textStyle: {
                color: '#90979c',
            },
            "data": ['本科生', '研究生','教师','其他']
        },


        "calculable": true,
        "xAxis": [{
            "name":"时间",
            "type": "category",
            "axisLine": {
                lineStyle: {
                    color: '#222'
                }
            },
            "splitLine": {
                "show": false
            },
            "axisTick": {
                "show": false
            },
            "splitArea": {
                "show": false
            },
            "axisLabel": {
                rotate:40,
                "interval": 0,

            },
            "data": month,
        }],
        "yAxis": [{
            "name":"人次",
            "type": "value",
            "splitLine": {
                "show": false
            },
            "axisLine": {
                lineStyle: {
                    color: '#222'
                }
            },
            "axisTick": {
                "show": false
            },
            "axisLabel": {
                "interval": 0,

            },
            "splitArea": {
                "show": false
            },

        }],
        /*dataZoom: [{
         type: 'inside',
         start: 70,
         end: 100
         }, {
         start: 70,
         end: 100,
         handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
         handleSize: '80%',
         handleStyle: {
         color: '#fff',
         shadowBlur: 3,
         shadowColor: 'rgba(0, 0, 0, 0.6)',
         shadowOffsetX: 2,
         shadowOffsetY: 2
         }
         }],*/
        "series": [{
            "name": "本科生",
            "type": "bar",
            "stack": "总量",
            "barMaxWidth": 35,
            "barGap": "10%",
            "itemStyle": {
                "normal": {
                    "color": "rgba(255,144,128,1)",
                    "label": {
                        "show": false,
                        "textStyle": {
                            "color": "#fff"
                        },
                        "position": "insideTop",
                        formatter: function(p) {
                            return p.value > 0 ? (p.value) : '';
                        }
                    }
                }
            },
            "data": ereadtimesu,
        },

            {
                "name": "研究生",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(0,191,183,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": ereadtimesg
            },
            {
                "name": "教师",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(30,144,255,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": ereadtimest
            },{
                "name": "其他",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(255,165,0,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": ereadtimeso
            },{
                "name": "总数",
                "type": "line",
                "stack": "总量",
                symbolSize:10,
                symbol:'circle',
                "itemStyle": {
                    "normal": {
                        "color": "rgba(30,144,255,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": true,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data":amounteread
            },
        ]
    };
    eread_count.setOption(eread_count_option);
}
function seatchart(chartid){
    var seat_count = echarts.init(document.getElementById(chartid));
    var  seat_count_option ={
        /*backgroundColor: "#344b58",*/
        animation:false,
        "tooltip": {
            "trigger": "axis",
            "axisPointer": {
                "type": "shadow",
                textStyle: {
                    color: "#222"
                }

            },
        },
        /*"grid": {
         "borderWidth": 0,
         "top": 110,
         "bottom": 95,
         textStyle: {
         color: "#222"
         }
         },*/
        "legend": {
            /*right: '10%',*/
            /*top: '11%',*/
            textStyle: {
                color: '#90979c',
            },
            "data": ['本科生', '研究生','教师','其他']
        },


        "calculable": true,
        "xAxis": [{
            "name":"时间",
            "type": "category",
            "axisLine": {
                lineStyle: {
                    color: '#222'
                }
            },
            "splitLine": {
                "show": false
            },
            "axisTick": {
                "show": false
            },
            "splitArea": {
                "show": false
            },
            "axisLabel": {
                rotate:40,
                "interval": 0,

            },
            "data": month,
        }],
        "yAxis": [{
            "name":"人次",
            "type": "value",
            "splitLine": {
                "show": false
            },
            "axisLine": {
                lineStyle: {
                    color: '#222'
                }
            },
            "axisTick": {
                "show": false
            },
            "axisLabel": {
                "interval": 0,

            },
            "splitArea": {
                "show": false
            },

        }],
        /*dataZoom: [{
         type: 'inside',
         start: 70,
         end: 100
         }, {
         start: 70,
         end: 100,
         handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
         handleSize: '80%',
         handleStyle: {
         color: '#fff',
         shadowBlur: 3,
         shadowColor: 'rgba(0, 0, 0, 0.6)',
         shadowOffsetX: 2,
         shadowOffsetY: 2
         }
         }],*/
        "series": [{
            "name": "本科生",
            "type": "bar",
            "stack": "总量",
            "barMaxWidth": 35,
            "barGap": "10%",
            "itemStyle": {
                "normal": {
                    "color": "rgba(255,144,128,1)",
                    "label": {
                        "show": false,
                        "textStyle": {
                            "color": "#fff"
                        },
                        "position": "insideTop",
                        formatter: function(p) {
                            return p.value > 0 ? (p.value) : '';
                        }
                    }
                }
            },
            "data": seattimesu,
        },

            {
                "name": "研究生",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(0,191,183,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": seattimesg
            },
            {
                "name": "教师",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(30,144,255,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": seattimest
            },{
                "name": "其他",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(255,165,0,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": seattimeso
            },{
                "name": "总数",
                "type": "line",
                "stack": "总量",
                symbolSize:10,
                symbol:'circle',
                "itemStyle": {
                    "normal": {
                        "color": "rgba(30,144,255,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": true,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data":amountseat
            },
        ]
    };
    seat_count.setOption(seat_count_option);
}
function equipmentchart(chartid){
    var equipment_count = echarts.init(document.getElementById(chartid));
    var  equipment_count_option ={
        /*backgroundColor: "#344b58",*/
        animation:false,
        "tooltip": {
            "trigger": "axis",
            "axisPointer": {
                "type": "shadow",
                textStyle: {
                    color: "#222"
                }

            },
        },
        /*"grid": {
         "borderWidth": 0,
         "top": 110,
         "bottom": 95,
         textStyle: {
         color: "#222"
         }
         },*/
        "legend": {
            /*right: '10%',*/
            /*top: '11%',*/
            textStyle: {
                color: '#90979c',
            },
            "data": ['本科生', '研究生','教师','其他']
        },


        "calculable": true,
        "xAxis": [{
            "name":"时间",
            "type": "category",
            "axisLine": {
                lineStyle: {
                    color: '#222'
                }
            },
            "splitLine": {
                "show": false
            },
            "axisTick": {
                "show": false
            },
            "splitArea": {
                "show": false
            },
            "axisLabel": {
                rotate:40,
                "interval": 0,

            },
            "data": month,
        }],
        "yAxis": [{
            "name":"人次",
            "type": "value",
            "splitLine": {
                "show": false
            },
            "axisLine": {
                lineStyle: {
                    color: '#222'
                }
            },
            "axisTick": {
                "show": false
            },
            "axisLabel": {
                "interval": 0,

            },
            "splitArea": {
                "show": false
            },

        }],
        /*dataZoom: [{
         type: 'inside',
         start: 70,
         end: 100
         }, {
         start: 70,
         end: 100,
         handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
         handleSize: '80%',
         handleStyle: {
         color: '#fff',
         shadowBlur: 3,
         shadowColor: 'rgba(0, 0, 0, 0.6)',
         shadowOffsetX: 2,
         shadowOffsetY: 2
         }
         }],*/
        "series": [{
            "name": "本科生",
            "type": "bar",
            "stack": "总量",
            "barMaxWidth": 35,
            "barGap": "10%",
            "itemStyle": {
                "normal": {
                    "color": "rgba(255,144,128,1)",
                    "label": {
                        "show": false,
                        "textStyle": {
                            "color": "#fff"
                        },
                        "position": "insideTop",
                        formatter: function(p) {
                            return p.value > 0 ? (p.value) : '';
                        }
                    }
                }
            },
            "data": equipmenttimesu,
        },

            {
                "name": "研究生",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(0,191,183,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": equipmenttimesg
            },
            {
                "name": "教师",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(30,144,255,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": equipmenttimest
            },{
                "name": "其他",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(255,165,0,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": false,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": equipmenttimeso
            },{
                "name": "总数",
                "type": "line",
                "stack": "总量",
                symbolSize:10,
                symbol:'circle',
                "itemStyle": {
                    "normal": {
                        "color": "rgba(30,144,255,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": true,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data":amountequipment
            },
        ]
    };
    equipment_count.setOption(equipment_count_option);
}
function day_gctrl() {
    $.get('../../gctrl/ByDay2').done(function (resultdata) {
        // 填入数据
        var day_gctrl = echarts.init(document.getElementById('day_gctrl'));
        var gctrl_times=resultdata.gctrl_times;
        var times=resultdata.times;
        var year=resultdata.year[0];
        if(typeof(year)=="undefined"){
            var date=new Date;
            year=year=date.getFullYear();
        }
        var data=[];
        for(var i=0;i<times.length;i++){
            var onedata=[];
            onedata.push(times[i]);
            onedata.push(gctrl_times[i]);
            data.push(onedata);
        }
        var day_count_option_option = {
            // backgroundColor: '#404a59',
            /*title: {
             top: 30,
             text: year+'年每天进馆人数',
             left: 'center',
             textStyle: {
             }
             },*/
            animation:false,
            tooltip : {
                trigger: 'item',
                position: 'top',
                formatter: function (params) {
                    // console.log(params);
                    //return "000"
                    return params.data[0] + '     进馆' +':'+ params.data[1]+ '人' ;
                }
            },
            legend: {
                top: '30',
                left: '100',
                data:['人数'],
                textStyle: {
                    // color: '#fff'
                }
            },
            calendar: [{
                top: 100,
                left: 'center',
                range: [year+'-01-01', year+'-06-30'],
                dayLabel:{nameMap : 'cn'},
                monthLabel :{nameMap : 'cn'},
                splitLine: {
                    show: true,
                    lineStyle: {
                        color: '#000',
                        width: 4,
                        type: 'solid'
                    }
                },
                yearLabel: {
                    formatter: '{start} 上半年',
                    textStyle: {
                        color: '#fff'
                    }
                },
                itemStyle: {
                    normal: {
                        //color: '#323c48',
                        borderWidth: 1,
                        borderColor: '#111'
                    }
                }
            }, {
                top: 340,
                left: 'center',
                range: [year+'-07-01', year+'-12-31'],
                dayLabel:{nameMap : 'cn'},
                monthLabel :{nameMap : 'cn'},
                splitLine: {
                    show: true,
                    lineStyle: {
                        color: '#000',
                        width: 4,
                        type: 'solid'
                    }
                },
                yearLabel: {
                    formatter: '{start} 下半年',
                    textStyle: {
                        color: '#fff'
                    }
                },
                itemStyle: {
                    normal: {
                        // color: '#323c48',
                        borderWidth: 1,
                        borderColor: '#111'
                    }
                }
            }],
            series : [
                {
                    name: '人数',
                    type: 'scatter',
                    coordinateSystem: 'calendar',
                    data: data,
                    symbolSize: function (val) {
                        return val[1] / 500;
                    },
                    itemStyle: {
                        normal: {
                            color: '#ddb926'
                        }
                    }
                },
                {
                    name: '人数',
                    type: 'scatter',
                    coordinateSystem: 'calendar',
                    calendarIndex: 1,
                    data: data,
                    symbolSize: function (val) {
                        return val[1] / 500;
                    },
                    itemStyle: {
                        normal: {
                            color: '#ddb926'
                        }
                    }
                },
            ]
        };
        day_gctrl.setOption(day_count_option_option);
    });
}
function dctrl_top12() {
    var gctrl_top12 = echarts.init(document.getElementById('gctrl_top12'));
    $.get('../../gctrl/ByDay_count2').done(function (resultdata) {
        // 填入数据
        var day_count2_option = {
            animation:false,
            legend: {
                data: ['日进馆排名'],
                align: 'left'
            },
            grid: {
                left: '10%',
                right: '10%',
                containLabel: true
            },
            tooltip: {},
            xAxis: {
                data: resultdata.time,
                'axisLabel': {
                    rotate:30,
                    'interval': 0
                },
                silent: false,
                splitLine: {
                    show: false
                }
            },
            yAxis: {
            },
            series: [{
                name: '日进馆排名',
                type: 'bar',
                data: resultdata.gctrl_times,
                itemStyle:{
                    normal:{
                        color:'#45e4cb',
                    }
                },
                animationDelay: function (idx) {
                    return idx * 10;
                }
            }],
            animationEasing: 'elasticOut',
            animationDelayUpdate: function (idx) {
                return idx * 5;
            }
        };
        gctrl_top12.setOption(day_count2_option);
    });
}
function getpublish_raking() {
    $.ajax({
        type:'get',
        url:'../../bookLend/ByPublisher',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data) {
            for(var key in data){
            }
            var option = {
                animation:false,
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    },
                    formatter: "{a} <br/>{b} : {c}次"
                },
                legend: {
                    data: ['借阅出版社排名']
                },
                grid: {
                    top:'0%',
                    left: '3%',
                    right: '4%',
                    bottom:'0%',
                    containLabel: true
                },
                xAxis: {
                    type: 'value',
                    boundaryGap: [0, 0.01],
                    "axisLabel": {
                        "interval": 0,
                        formatter: '{value}次',
                    }
                },
                yAxis: {
                    type: 'category',
                    data: data[key].publisher
                },
                series: [{
                    name: '借阅出版社排名',
                    type: 'bar',
                    data: data[key].times
                }]
            };
            var chart = echarts.init(document.getElementById('publisher_raking'));
            chart.setOption(option);
        }
    })
}
function getpublish_rating() {
    $.ajax({
        type:'get',
        url:'../../bookLend/ByPublisher',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data) {
            for(var key in data){
            }
            var piedatalist = [];
            for (var k = 0; k < data[key].publisher.length; k++) {
                var piedata = {};
                piedata.value = data[key].times[k];
                piedata.name = data[key].publisher[k];
                piedatalist.push(piedata);
            }
            var option = {
                animation:false,
                tooltip: {
                    trigger: 'item',
                    formatter: "借阅量<br/>{b} : {c} ({d}%)"
                },
                legend: {
                    top: 'center',
                    left: 20,
                    orient: 'vertical',
                    bottom: 20,
                    data: data[key].publisher
                },
                calculable: true,
                series: [
                    {
                        name: '面积模式',
                        type: 'pie',
                        radius: [30, 130],
                        center: ['50%', '50%'],
                        roseType: 'area',
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        lableLine: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data: piedatalist
                    }
                ]
            };
            var chart = echarts.init(document.getElementById('publisher_rating'));
            chart.setOption(option);
        }
    })
}
function downloadword(){
	var img_Book_Amount =echarts.init(document.getElementById("getResourceCountBy_year")).getDataURL();
        var img_gctrl_amount =echarts.init(document.getElementById("getGctrlsCountBy_year")).getDataURL();
        var img_month_amount =echarts.init(document.getElementById("getGctrlsCountBy_month")).getDataURL();
        var img_type_percent1 =echarts.init(document.getElementById("getmankindGctrl_Byoneyear")).getDataURL();
        var img_type_percent2 =echarts.init(document.getElementById("getmankindCount_Byyear")).getDataURL();
        var img_lend_yearamount =echarts.init(document.getElementById("getBook_LendCountBy_year")).getDataURL();
        var img_type_reader =echarts.init(document.getElementById("getBookkindAllCount_Byyear")).getDataURL();
        var img_academy_img =echarts.init(document.getElementById("getBook_LendCountBy_academyAndyear")).getDataURL();
        var img_leader_img =echarts.init(document.getElementById("getbooklendPeopleAndCount_Byhour")).getDataURL();
        var img_borrow_img1 =echarts.init(document.getElementById("getlend_student_type")).getDataURL();
        var img_borrow_img2 =echarts.init(document.getElementById("getlendrenew_student_type")).getDataURL();
        var img_read_img =echarts.init(document.getElementById("geICdurationCountBy_year")).getDataURL();
        var img_seat_img =echarts.init(document.getElementById("geICdurationBy_year")).getDataURL();
        var img_ebook_spend =echarts.init(document.getElementById("geteread_hour")).getDataURL();
        var img_print_amount =echarts.init(document.getElementById("getprintsCountBy_year")).getDataURL();
        var img_print_dy =echarts.init(document.getElementById("getprinttimesCountBy_year")).getDataURL();
        var img_print_fy =echarts.init(document.getElementById("getcopytimesCountBy_year")).getDataURL();
        var img_print_sm =echarts.init(document.getElementById("getscantimesCountBy_year")).getDataURL();
        var img_print_day =echarts.init(document.getElementById("getprints_hour")).getDataURL();
        var publisher_rating =echarts.init(document.getElementById("publisher_rating")).getDataURL();
        var publisher_raking =echarts.init(document.getElementById("publisher_raking")).getDataURL();
        var gctrl_top12 =echarts.init(document.getElementById("gctrl_top12")).getDataURL();
        var day_gctrl =echarts.init(document.getElementById("day_gctrl")).getDataURL();
        var croom =echarts.init(document.getElementById("croom")).getDataURL();
        var eread =echarts.init(document.getElementById("eread")).getDataURL();
        var seat =echarts.init(document.getElementById("seat")).getDataURL();
        var equipment =echarts.init(document.getElementById("equipment")).getDataURL();
        var typechart = echarts.init(document.getElementById("typechart")).getDataURL();
        var typenumber = echarts.init(document.getElementById("typenumber")).getDataURL();
        var getCollectionBycategorytype = echarts.init(document.getElementById("getCollectionBycategorytype")).getDataURL();
        var getCollectionBycategorynumber = echarts.init(document.getElementById("getCollectionBycategorynumber")).getDataURL();
        var getCollectionOverall = echarts.init(document.getElementById("getCollectionOverall")).getDataURL();
        var getCollectionNewAdded = echarts.init(document.getElementById("getCollectionNewAdded")).getDataURL();
        var getCollectionNewAddedByCate = echarts.init(document.getElementById("getCollectionNewAddedByCate")).getDataURL();
        var getCollectionTuShuNewAddedByCate = echarts.init(document.getElementById("getCollectionTuShuNewAddedByCate")).getDataURL();
        var getCollectionWaiWenNewAddedByCate = echarts.init(document.getElementById("getCollectionWaiWenNewAddedByCate")).getDataURL();
        var img_academy_top1 = echarts.init(document.getElementById("getBookLendByAcademyFirst")).getDataURL();
        var img_academy_top2 = echarts.init(document.getElementById("getBookLendByAcademySecond")).getDataURL();
        var img_academy_top3 = echarts.init(document.getElementById("getBookLendByAcademyThird")).getDataURL();
        var postdata = {
            "img_Book_Amount" :img_Book_Amount,
            "img_gctrl_amount" :img_gctrl_amount,
            "img_month_amount" :img_month_amount,
            "img_type_percent1" :img_type_percent1,
            "img_type_percent2" :img_type_percent2,
            "img_lend_yearamount" :img_lend_yearamount,
            "img_type_reader" :img_type_reader,
            "img_academy_img" :img_academy_img,
            "img_leader_img" : img_leader_img,
            "img_borrow_img1" :img_borrow_img1,
            "img_borrow_img2" :img_borrow_img2,
            "img_read_img" :img_read_img,
            "img_seat_img" :img_seat_img,
            "img_ebook_spend" :img_ebook_spend,
            "img_print_amount":img_print_amount,
            "img_print_dy":img_print_dy,
            "img_print_fy":img_print_fy,
            "img_print_sm":img_print_sm,
            "img_print_day" :img_print_day,
            "publisher_rating":publisher_rating,
            "publisher_raking":publisher_raking,
            "gctrl_top12":gctrl_top12,
            "day_gctrl":day_gctrl,
            "croom":croom,
            "eread":eread,
            "seat":seat,
            "equipment":equipment,
            "typechart":typechart,
            "typenumber":typenumber,
            "getCollectionBycategorytype":getCollectionBycategorytype,
            "getCollectionBycategorynumber":getCollectionBycategorynumber,
            "getCollectionOverall":getCollectionOverall,
            "getCollectionNewAdded":getCollectionNewAdded,
            "getCollectionNewAddedByCate":getCollectionNewAddedByCate,
            "getCollectionTuShuNewAddedByCate":getCollectionTuShuNewAddedByCate,
            "getCollectionWaiWenNewAddedByCate":getCollectionWaiWenNewAddedByCate,
            "img_academy_top1":img_academy_top1,
            "img_academy_top2":img_academy_top2,
            "img_academy_top3":img_academy_top3,
        }
        $.ajax({
            type:"POST",
            contentType: 'application/json;charset=UTF-8',
            data:JSON.stringify(postdata),
            url:"http://106.14.120.137:8080/SmartLibrary/report/getreport",
            dataType: 'json',
            success: function(data, textStatus, jqXHR){
                console.log(data);
                if(data==1){
                    try{
                       /* 第一版导出word
                       var elemIF = document.createElement("iframe");
                        elemIF.src = "../../report/2.docx";
                        elemIF.style.display = "none";
                        document.body.appendChild(elemIF);*/
                       replace["img_Book_Amount"] = url+"/reportpic/img_Book_Amount.jpg";
                        replace["img_gctrl_amount"] = url+"/reportpic/img_gctrl_amount.jpg";
                        replace["img_month_amount"] = url+"/reportpic/img_month_amount.jpg";
                        replace["img_type_percent1"] = url+"/reportpic/img_type_percent1.jpg";
                        replace["img_type_percent2"] = url+"/reportpic/img_type_percent2.jpg";
                        replace["img_lend_yearamount"] = url+"/reportpic/img_lend_yearamount.jpg";
                        replace["img_type_reader"] = url+"/reportpic/img_type_reader.jpg";
                        replace["img_leader_img"] = url+"/reportpic/img_leader_img.jpg";
                        replace["img_borrow_img1"] = url+"/reportpic/img_borrow_img1.jpg";
                        replace["img_borrow_img2"] = url+"/reportpic/img_borrow_img2.jpg";
                        replace["img_read_img"] = url+"/reportpic/img_read_img.jpg";
                        replace["img_seat_img"] = url+"/reportpic/img_seat_img.jpg";
                        replace["img_ebook_spend"] = url+"/reportpic/img_ebook_spend.jpg";
                        replace["img_print_amount"] = url+"/reportpic/img_print_amount.jpg";
                        replace["img_print_dy"] = url+"/reportpic/img_print_dy.jpg";
                        replace["img_print_fy"] = url+"/reportpic/img_print_fy.jpg";
                        replace["img_print_sm"] = url+"/reportpic/img_print_sm.jpg";
                        replace["img_print_day"] = url+"/reportpic/img_print_day.jpg";
                        replace["day_gctrl"] = url+"/reportpic/day_gctrl.jpg";
                        replace["gctrl_top12"] = url+"/reportpic/gctrl_top12.jpg";
                        replace["publisher_raking"] = url+"/reportpic/publisher_raking.jpg";
                        replace["publisher_rating"] = url+"/reportpic/publisher_rating.jpg";
                        replace["croom"] = url+"/reportpic/croom.jpg";
                        replace["eread"] = url+"/reportpic/eread.jpg";
                        replace["seat"] = url+"/reportpic/seat.jpg";
                        replace["equipment"] = url+"/reportpic/equipment.jpg";
                        replace["typechart"] = url+"/reportpic/typechart.jpg";
                        replace["typenumber"] = url+"/reportpic/typenumber.jpg";
                        replace["getCollectionBycategorytype"] = url+"/reportpic/getCollectionBycategorytype.jpg";
                        replace["getCollectionBycategorynumber"] = url+"/reportpic/getCollectionBycategorynumber.jpg";
                        replace["getCollectionOverall"] = url+"/reportpic/getCollectionOverall.jpg";
                        replace["getCollectionNewAdded"] = url+"/reportpic/getCollectionNewAdded.jpg";
                        replace["getCollectionNewAddedByCate"] = url+"/reportpic/getCollectionNewAddedByCate.jpg";
                        replace["getCollectionTuShuNewAddedByCate"] = url+"/reportpic/getCollectionTuShuNewAddedByCate.jpg";
                        replace["getCollectionWaiWenNewAddedByCate"] = url+"/reportpic/getCollectionWaiWenNewAddedByCate.jpg";
                        replace["img_academy_img"] = url+"/reportpic/img_academy_img.jpg";
                        replace["img_academy_top1"] = url+"/reportpic/img_academy_top1.jpg";
                        replace["img_academy_top2"] = url+"/reportpic/img_academy_top2.jpg";
                        replace["img_academy_top3"] = url+"/reportpic/img_academy_top3.jpg";
                       XDoc.run("http://106.14.120.137:8080/SmartLibrary/report/88.docx","docx",
                           replace ,"_blank");
                    }catch(e){

                    }
                }
            }
        });
}
function getResourceCountBy_year() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/getResourceCountBy_year',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var year = [];
            var count = [];
            var count1 = [];
            for(var i=0;i<data.length;i++){
                year.push(data[i].year);
                count.push({
                    value:data[i].count,
                    itemStyle:{
                        normal:{
                            color:'orange'

                        }
                    }
                });
                count1.push(data[i].count)
            }
            var getResourceCountBy_year = echarts.init(document.getElementById('getResourceCountBy_year'));
            var option = {
                backgroundColor:'white',
                animation:false,
                xAxis: [
                    {
                        name:'年',
                        type: 'category',
                        show:true,
                        data: year,
                        axisPointer: {
                            type: 'shadow'
                        },
                        axisTick: {
                            show: false
                        },
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '资源数',
                        /*min: 0,
                        max:100,
                        interval: 20,*/
                        axisLabel: {
                            formatter: '{value}'
                        },
                        axisTick: {
                            show: false
                        }
                    },

                ],
                series: [
                    {
                        /*name:'保障率',*/
                        type:'bar',
                        barWidth: '30%',
                        data:count,
                        label: {
                            normal: {
                                show: true,
                                position: 'top',
                                formatter: '{c}'
                            }
                        },
                    },

                    {
                        type:'line',
                        name:'占比',
                        data:count1
                    }
                ],
            };
            getResourceCountBy_year.setOption(option);
        }
    });
}
function getGctrlsCountBy_year() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/getGctrlsCountBy_year',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data) {
            var year = [];
            var gctrl = [];
            for(var i=0;i<data.length;i++){
                year.push(data[i].year);
                gctrl.push(data[i].gctrls);
            }
            var max = Max(gctrl);
            $(".gctrl-intro").find(".first-year").text(data[0].year);
            $(".gctrl-intro").find(".last-year").text(data[data.length - 1].year);
            $(".gctrl-intro").find(".max-year").text(year[parseInt(max.p)]);
            $(".gctrl-intro").find(".max-num").text(max.num);
            replace["gctrl_year1"] = data[0].year;
            replace["gctrl_year2"] = data[data.length - 1].year;
            replace["gctrl_year3"] = year[parseInt(max.p)];
            replace["gctrl_amount"] = max.num;
            var getgetGctrlsCountBy_year = echarts.init(document.getElementById('getGctrlsCountBy_year'));
            var GctrlsCountBy_yearoption = {
                animation:false,
                backgroundColor:'white',
                color: ['#3398DB'],
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'line'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '2%',
                    right: '8%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis : [
                    {
                        name:'年',
                        type : 'category',
                        data : year,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis : [
                    {
                        // type : 'category',
                        // data : ['10','20','30','40'],
                        name:"人次",
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                series : [
                    {
                        name:'进馆人次',
                        type:'bar',
                        barWidth: '40%',
                        data:gctrl
                    }

                ],
                label: {
                    normal: {
                        show: true,
                        position: 'top',
                        formatter: '{c}'
                    }
                },
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(17, 168,171, 1)'
                        }, {
                            offset: 1,
                            color: 'rgba(17, 168,171, 0.1)'
                        }]),
                        shadowColor: 'rgba(0, 0, 0, 0.1)',
                        shadowBlur: 10
                    }
                }
            };
            getgetGctrlsCountBy_year.setOption(GctrlsCountBy_yearoption);
        }
    });

}
function getGctrlsCountBy_month() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getGctrlsCountBy_month',
        dataType:'json',
        async:false,
        success:function (data) {
            var month = [];
            var gctrl_times = [];
            for(var i=0;i<data.length;i++){
                month.push(data[i].month+'月');
                gctrl_times.push(data[i].gctrl_times);
            }
            var max = Max(gctrl_times);
            $(".month-gctrl").find(".first-year").text(data[0].year);
            $(".month-gctrl").find(".first-month").text(data[0].month);
            $(".month-gctrl").find(".last-year").text(data[data.length - 1].year);
            $(".month-gctrl").find(".last-month").text(data[data.length - 1].month);
            $(".month-gctrl").find(".total").text(Sum(gctrl_times));
            $(".month-gctrl").find(".max-month").text(month[parseInt(max.p)]);
            replace["gctrl_month_year1"] = data[0].year;
            replace["gctrl_month_month1"] = data[0].month;
            replace["gctrl_month_year2"] = data[data.length - 1].year;
            replace["gctrl_month_month2"] = data[data.length - 1].month;
            replace["gctrl_month_amount"] = Sum(gctrl_times);
            replace["gctrl_month_month3"] = month[parseInt(max.p)];
            replace["img_title_year"] = data[0].year;
            var getGctrlsCountBy_month = echarts.init(document.getElementById('getGctrlsCountBy_month'));
            var getGctrlsCountBy_monthoption = {
                animation:false,
                backgroundColor:'white',
                tooltip : {
                    trigger: 'axis'
                },
                grid:{
                  left:'12%'
                },
                calculable : true,
                xAxis : [
                    {
                        name:'月',
                        type : 'category',
                        data : month,
                        axisLabel:{interval:0}
                    }
                ],
                yAxis : [
                    {
                        name:'人次',
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'进馆人次',
                        type:'bar',
                        barWidth:'40%',
                        data:gctrl_times,
                        itemStyle: {
                            normal: {
                                color: function(params) {
                                    // build a color map as your need.
                                    var colorList = [
                                        '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                                        '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                                        '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                                    ];
                                    return colorList[params.dataIndex]
                                },label: {
                                    show: true,
                                    position: 'top',
                                    formatter: '{c}'
                                }
                            }
                        }
                    }
                ]
            };
            getGctrlsCountBy_month.setOption(getGctrlsCountBy_monthoption);
        }
    });
}
function getmankindGctrl_Byoneyear() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getmankindCount_Byoneyear',
        async:false,
        dataType:'json',
        success:function(data){
            var gctrldata = [];
            var type=[];
            var gctrlNum=[];
            for(var i=0;i<data.length;i++){
                gctrldata.push({
                    value:data[i].gctrl,
                    name:data[i].man_kind
                });
                type.push(data[i].man_kind);
                gctrlNum.push(data[i].gctrl);
            }
            var max = Max(gctrlNum);
            var total = Sum(gctrlNum);
            $(".gctrl-type").find(".max-type").text(type[parseInt(max.p)]);
            $(".gctrl-type").find(".max-num").text((max.num/total*100).toFixed(2));
            replace["gctrl_type_year1"] = data[0].year;
            replace["gctrl_type_student"] = type[parseInt(max.p)];
            replace["gctrl_type_percent"] = (max.num/total*100).toFixed(2);
            replace["img_type_year"] = data[0].year;
            var getmankindGctrl_Byoneyear = echarts.init(document.getElementById('getmankindGctrl_Byoneyear'));
            var getmankindGctrl_Byoneyearoption = {
                animation:false,
                backgroundColor:'white',
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                calculable : true,
                series : [
                    {
                        name:data[0].year+'年',
                        type:'pie',
                        radius : [60, 100],
                        center : ['50%', '50%'],
                        roseType : 'radius',
                        data:gctrldata
                    }
                ]
            };
            getmankindGctrl_Byoneyear.setOption(getmankindGctrl_Byoneyearoption);
        }
    })
}
function getmankindCount_Byyear() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getmankindCount_Byyear',
        dataType:'json',
        async:false,
        success:function (data) {
            var getmankindCount_Byyearyear = new Array();
            var mankinddata = [];
            var other = [];
            var student = [];
            var teacher = [];
            var gradute = [];
            for(var i=0;i<data.length;i++){
                if($.inArray(data[i].year, getmankindCount_Byyearyear)==-1){
                    getmankindCount_Byyearyear.push(data[i].year);
                }
                if(data[i].man_kind=='其他'){
                    other.push(data[i].gctrl);
                }
                else if(data[i].man_kind=='教职工'){
                    teacher.push(data[i].gctrl);
                }
                else if(data[i].man_kind=='本科生'){
                    student.push(data[i].gctrl);
                }
                else if(data[i].man_kind=='研究生'){
                    gradute.push(data[i].gctrl);
                }
            }
            mankinddata.push({
                name:'其他',
                type:'line',
                data:other
            });
            mankinddata.push({
                name:'教职工',
                type:'line',
                data:teacher
            });
            mankinddata.push({
                name:'本科生',
                type:'line',
                data:student
            });
            mankinddata.push({
                name:'研究生',
                type:'line',
                data:gradute
            });
            var getmankindCount_Byyear = echarts.init(document.getElementById('getmankindCount_Byyear'));
            var getmankindCount_Byyearoption = {
                animation:false,
                backgroundColor:'white',
                xAxis: {
                    name:'年',
                    data:getmankindCount_Byyearyear
                },
                grid:{
                  left:'14%',
                  right:'8%',
                  bottom:'10%'
                },
                legend: {
                    top:'5%',
                    align: 'right',
                    data: ['其他','教职工','本科生','研究生'],
                    textStyle: {
                        align: 'right',
                        baseline: 'middle',
                        fontFamily: 'IRANSans'
                    }
                },
                yAxis: {
                    name:'人次'
                },
                series: mankinddata
            };
            getmankindCount_Byyear.setOption(getmankindCount_Byyearoption);
        }
    })
}
function getBook_LendCountBy_year() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getBook_LendCountBy_year',
        async:false,
        dataType:'json',
        success:function (data) {
            var book_lend_year = [];
            var book_lend_times = [];
            var book_return_times = [];
            var book_total=[];
            for(var i=0;i<data.length;i++){
                book_lend_year.push(data[i].year);
                book_lend_times.push(data[i].book_lend_times);
                book_return_times.push(data[i].book_return_times);
                book_total.push(data[i].book_lend_times+data[i].book_return_times);
            }
            var max= Max(book_total);
            $(".lend-return").find(".max-year").text(book_lend_year[max.p]);
            $(".lend-return").find(".max-total").text(max.num);
            replace["lend_top1_year"] = book_lend_year[max.p];
            replace["lend_top1_amount"] = max.num;
            var secYear;
            var sortTotal = book_total.sort();
            for(var i=0;i<data.length;i++){
                if(book_total[i]==sortTotal[sortTotal.length-2]){
                    secYear = data[i].year;
                }
            }
            $(".lend-return").find(".sec-year").text(secYear);
            $(".lend-return").find(".sec-total").text(sortTotal[sortTotal.length-2]);
            replace["lend_top2_year"] = secYear;
            replace["lend_top2_amount"] = sortTotal[sortTotal.length-2];
            var getBook_LendCountBy_year = echarts.init(document.getElementById('getBook_LendCountBy_year'));
            var getBook_LendCountBy_yearoption ={
                animation:false,
                color:['#63C2FF','#FFCB8C'],
                backgroundColor:'white',
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    top:'5%',
                    data: ['借书', '还书']
                },
                grid: {
                    left: '3%',
                    right: '8%',
                    bottom: '3%',
                    containLabel: true
                },
                yAxis:  {
                    name:'册',
                    type: 'value'
                },
                xAxis: {
                    name:'年',
                    type: 'category',
                    data: book_lend_year
                },
                series: [
                    {
                        name: '借书',
                        type: 'bar',
                        stack: '总量',
                        barWidth:'40%',
                        label: {
                            normal: {
                                show: true,
                                position: 'inside',
                                color:'#666'
                            }
                        },
                        data: book_lend_times
                    },
                    {
                        name: '还书',
                        type: 'bar',
                        stack: '总量',
                        barWidth:'40%',
                        label: {
                            normal: {
                                show: true,
                                position: 'inside',
                                color:'#666'
                            }
                        },
                        data: book_return_times
                    }
                ]
            };
            getBook_LendCountBy_year.setOption(getBook_LendCountBy_yearoption);
        }
    })
}
function getBookkindAllCount_Byyear() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getBookkindAllCount_Byyear',
        async:false,
        dataType:'json',
        success:function (data) {
            var bookkind = [];
            var bookkinddata = [];
            for(var i=0;i<data.length;i++){
                bookkind.push(data[i].book_kind);
                bookkinddata.push(data[i].book_lend_times);
            }
            var max = Max(bookkinddata);
            $(".lend-type").find(".max-type").text(bookkind[parseInt(max.p)]);
            $(".lend-type").find(".max-num").text(max.num);
            var sortLend = sortByKey(data,'book_lend_times');
            $(".lend-type").find(".sec-type").text(sortLend[sortLend.length-2].book_kind);
            $(".lend-type").find(".sec-num").text(sortLend[sortLend.length-2].book_lend_times);

            replace["lend_book_year"] = data[0].year;
            replace["lend_book_type1"] = bookkind[parseInt(max.p)];
            replace["lend_book_time1"] = max.num;
            replace["lend_book_type2"] = sortLend[sortLend.length-2].book_kind;
            replace["lend_book_time2"] = sortLend[sortLend.length-2].book_lend_times;
            replace["img_type_year"] = data[0].year;
            var getBookkindAllCount_Byyear = echarts.init(document.getElementById('getBookkindAllCount_Byyear'));
            var getBookkindAllCount_Byyearoption = {
                //color: ['#3398DB'],
                animation:false,
                tooltip: {
                    trigger: 'axis',
                    backgroundColor:'rgba(255,255,255,0.8)',
                    extraCssText: 'box-shadow: 0 0 8px rgba(0, 0, 0, 0.3);',
                    textStyle:{
                        color:'#6a717b',
                    },

                },
                grid: {
                    left: '2%',
                    right: '8%',
                    bottom: '5%',
                    containLabel: true
                },
                yAxis: [{
                    name:'借阅类别',
                    type: 'category',
                    data: bookkind,
                    axisTick: {
                        alignWithLabel: true
                    },
                    axisLabel: {
                        margin: 10,
                        textStyle: {
                            fontSize: 12,
                            color:'#94999f'
                        }
                    },
                    axisLine: {
                        lineStyle: {
                            color: '#999'
                        }
                    }

                }],
                xAxis: [{
                    type: 'value',
                    axisLabel: {
                        margin: 10,
                        textStyle: {
                            fontSize: 12,
                            color:'#94999f'
                        }
                    },
                    axisLine: {
                        lineStyle: {
                            color: '#fff'
                        }
                    },
                    splitLine: {
                        lineStyle: {
                            color: '#dbe0e6'
                        }
                    }



                }],
                backgroundColor: '#ffffff',
                series: [{
                    name: 'Top 10',
                    type: 'bar',
                    barWidth:'80%',
                    data: bookkinddata,
                    label: {
                        normal: {
                            show: false,
                            position: 'insideRight',
                            textStyle: {
                                color: '#666', //color of value
                                position:'right'
                            }
                        }
                    },


                    itemStyle: {

                        normal: {
                            color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [{
                                offset: 0,
                                color: '#64bdc8' // 0% 处的颜色
                            }, {
                                offset: 1,
                                color: '#00c484' // 100% 处的颜色
                            }], false),
                            barBorderRadius: [0, 15,15, 0],
                            shadowColor: 'rgba(0,0,0,0.1)',
                            shadowBlur: 3,
                            shadowOffsetY: 3
                        }
                    }
                }]
            };
            getBookkindAllCount_Byyear.setOption(getBookkindAllCount_Byyearoption);
        }
    })
}
function getBook_LendCountBy_academyAndyear() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getBook_LendCountBy_academyAndyear',
        dataType:'json',
        async:false,
        success:function (data) {
            var academy = [];
            var academylend = [];
            for(var i=0;i<data.length;i++){
                academy.push(data[i].academy);
                academylend.push(data[i].lend);
            }
            $(".academy-lend").find(".max-name").text(academy[0]);
            $(".academy-lend").find(".sec-name").text(academy[1]);
            $(".academy-lend").find(".third-name").text(academy[2]);
            replace["img_academy_year"] = data[0].year;
            replace["lend_top3_accdemy1"] = academy[0];
            replace["lend_top3_accdemy2"] = academy[1];
            replace["lend_top3_accdemy3"] = academy[2];
            var getBook_LendCountBy_academyAndyear = echarts.init(document.getElementById('getBook_LendCountBy_academyAndyear'));
            var getBook_LendCountBy_academyAndyearoption = {
                animation:false,
                backgroundColor:'white',
                color: ['#3398DB'],
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '3%',
                    right: '10%',
                    bottom: '13%',
                    containLabel: true
                },
                xAxis : [
                    {
                        name:'学院',
                        type : 'category',
                        data : academy,
                        axisTick: {
                            alignWithLabel: true
                        },
                        "axisLabel": {
                            "interval": 0,
                            "rotate": 30,
                            "show": true,
                            "splitNumber": 10,
                            "textStyle": {
                                "fontFamily": "黑体",
                                "fontSize": 12
                            }
                        }
                    }
                ],
                yAxis : [
                    {
                        // type : 'category',
                        // data : ['10','20','30','40'],
                        name:'册',
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                series : [
                    {
                        name:'借阅',
                        type:'bar',
                        barWidth: '40%',
                        data:academylend
                    },

                ],
                label: {
                    normal: {
                        show: true,
                        position: 'top',
                        formatter: '{c}'
                    }
                },
                itemStyle: {
                    normal: {

                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(17, 168,171, 1)'
                        }, {
                            offset: 1,
                            color: 'rgba(17, 168,171, 0.1)'
                        }]),
                        shadowColor: 'rgba(0, 0, 0, 0.1)',
                        shadowBlur: 10
                    }
                }
            };
            getBook_LendCountBy_academyAndyear.setOption(getBook_LendCountBy_academyAndyearoption);
        }

    })

}
function getbooklendPeopleAndCount_Byhour() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getbooklendPeopleAndCount_Byhour',
        dataType:'json',
        async:false,
        success:function (data) {
            var booklendhour = [];
            var lendpeople = [];
            var lendbookdata = [];
            for(var i=0;i<data.length;i++){
                booklendhour.push(data[i].hour+"点");
                lendpeople.push(data[i].lend_people);
                lendbookdata.push(data[i].lend);
            }
            var hour = [];
            var lend = [];
            var lendpeople = [];
            for(var i=0;i<data.length;i++){
                hour.push(data[i].hour);
                lend.push(data[i].lend);
                lendpeople.push(data[i].lend_people);
            }
            var max_lend = Math.max.apply(Math,lend);//借阅册数
            var lend_hour =hour[lend.indexOf(max_lend)];//借阅量的高峰期 lend_hour点-lend_hour+1点
            var max_lend_people = Math.max.apply(Math,lendpeople);//借阅人数
            var people_hour = hour[lendpeople.indexOf(max_lend_people)];//借阅人次最多时段 people_hour点-people_hour+1点
            $(".average-lend").find(".first-hour").text(lend_hour);
            $(".average-lend").find(".next-hour").text(lend_hour+1);
            $(".average-lend").find(".first-num").text(max_lend);
            $(".average-lend").find(".max-hour").text(people_hour);
            $(".average-lend").find(".second-hour").text(people_hour+1);
            $(".average-lend").find(".second-num").text(max_lend_people);
            replace["library_leader_year"] = data[0].year;
            replace["library_leader_clock1"] = lend_hour;
            replace["library_leader_clock2"] = lend_hour+1;
            replace["library_book_amount"] = max_lend;
            replace["library_lead_clock3"] = people_hour;
            replace["library_lead_clock4"] = people_hour+1;
            replace["library_leader_amount"] = max_lend_people;
            replace["img_leader_year"] = data[0].year;
            var getbooklendPeopleAndCount_Byhour = echarts.init(document.getElementById('getbooklendPeopleAndCount_Byhour'));
            var getbooklendPeopleAndCount_Byhouroption = {
                animation:false,
                backgroundColor: 'white',
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        lineStyle: {
                            color: '#57617B'
                        }
                    }
                },
                legend: {
                    icon: 'rect',
                    itemWidth: 14,
                    itemHeight: 5,
                    itemGap: 13,
                    top:'5%',
                    data: ['借出册数', '借出人数'],
                    right: 'center'
                },
                grid: {
                    left: '2%',
                    right: '10%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [{
                    name:'小时',
                    type: 'category',
                    boundaryGap: false,
                    axisLine: {
                        lineStyle: {
                            color: '#57617B'
                        }
                    },
                    data: booklendhour
                }],
                yAxis: [{
                    type: 'value',
                    axisTick: {
                        show: false
                    },
                    axisLine: {
                        lineStyle: {
                            color: '#57617B'
                        }
                    },
                    axisLabel: {
                        margin: 10,
                        textStyle: {
                            fontSize: 14
                        }
                    },
                    splitLine: {
                        lineStyle: {
                            color: '#57617B'
                        },
                        show:false,
                    }
                }],
                series: [{
                    name: '借出册数',
                    type: 'line',
                    smooth: true,
                    lineStyle: {
                        normal: {
                            width: 1
                        }
                    },
                    areaStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: 'rgba(17, 168, 171, 1)'
                            }, {
                                offset: 0.8,
                                color: 'rgba(17, 168, 171, 0.3)'
                            }], false),
                            shadowColor: 'rgba(0, 0, 0, 0.1)',
                            shadowBlur: 10
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: 'rgb(17, 168, 171)',
                            borderColor: 'rgba(17,168,171,0.27)',
                            borderWidth: 6
                        }
                    },
                    data: lendbookdata
                }, {
                    name: '借出人数',
                    type: 'line',
                    smooth: true,
                    lineStyle: {
                        normal: {
                            width: 1
                        }
                    },
                    areaStyle: {
                        normal: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: 'rgba(255, 69, 0, 1)'
                            }, {
                                offset: 0.8,
                                color: 'rgba(255, 69, 0, 0.3)'
                            }], false),
                            shadowColor: 'rgba(0, 0, 0, 0.1)',
                            shadowBlur: 10
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: 'rgb(255,69,0)',
                            borderColor: 'rgba(255,69,0,0.2)',
                            borderWidth: 6

                        }
                    },
                    data: lendpeople
                } ]
            };
            getbooklendPeopleAndCount_Byhour.setOption(getbooklendPeopleAndCount_Byhouroption);
        }
    })
}
function getlend_student_type(){
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getmankindCount_Byoneyear',
        async:false,
        dataType:'json',
        success:function (data) {
            var colorList = [
                '#59c5a7', '#51b8fe', '#fa827d','#FFCC67'
            ];
            // 总和
            var total = {
                name: '总借阅数',
                value: data[0].lend+data[1].lend+data[2].lend+data[3].lend
            }
            var originalData = [{
                value: data[0].lend,
                name: '其他：'+data[0].lend
            }, {
                value: data[1].lend,
                name: '教职工：'+data[1].lend
            }, {
                value: data[2].lend,
                name: "本科生："+data[2].lend
            }, {
                value: data[3].lend,
                name: "研究生："+data[3].lend
            }
            ];
            var sortData = sortByKey(data,'lend');
            var num = sortData[sortData.length-1].lend;
            $(".type-rate").find(".max-type").text(sortData[sortData.length-1].man_kind);
            $(".type-rate").find(".max-num").text((num/total.value*100).toFixed(2));
            replace["student_borrow_type"] = sortData[sortData.length-1].man_kind;
            replace["student_borrow_percent"] = (num/total.value*100).toFixed(2);
            replace["student_borrow_year"] = data[0].year;
            replace["img_borrow_year1"] = data[0].year;
            replace["img_borrow_year2"] = data[0].year;
            echarts.util.each(originalData, function(item, index) {
                item.itemStyle = {
                    normal: {
                        color: colorList[index]
                    }
                };
            });
            var getlend_student_typeoption = {
                animation:false,
                backgroundColor:'white',
                title: [{
                    text: total.name,
                    left: '49%',
                    top: '40%',
                    textAlign: 'center',
                    textBaseline: 'middle',
                    textStyle: {
                        color: '#999',
                        fontWeight: 'normal',
                        fontSize: 18
                    }
                }, {
                    text: total.value,
                    left: '49%',
                    top: '51%',
                    textAlign: 'center',
                    textBaseline: 'middle',
                    textStyle: {
                        color: '#666',
                        fontWeight: 'normal',
                        fontSize: 40
                    }
                }],
                series: [{
                    hoverAnimation: false, //设置饼图默认的展开样式
                    radius: [80, 100],
                    name: 'pie',
                    type: 'pie',
                    selectedMode: 'single',
                    selectedOffset: 16, //选中是扇区偏移量
                    clockwise: true,
                    startAngle: 90,
                    label: {
                        normal: {
                            textStyle: {
                                fontSize: 16,
                                color: '#999'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            lineStyle: {
                                color: '#999',

                            }
                        }
                    },
                    data: originalData
                }]
            };
            var getlend_student_type = echarts.init(document.getElementById('getlend_student_type'));
            getlend_student_type.setOption(getlend_student_typeoption);
        }
    })
}
function getlendrenew_student_type(){
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getmankindCount_Byoneyear',
        async:false,
        dataType:'json',
        success:function (data) {
            var colorList = [
                '#59c5a7', '#51b8fe', '#fa827d','#FFCC67'
            ];

            // 总和
            var total = {
                name: '总续借数',
                value: data[0].renew+data[1].renew+data[2].renew+data[3].renew
            };

            var originalData = [{
                value: data[0].renew,
                name: '其他：'+data[0].renew
            }, {
                value: data[1].renew,
                name: '教职工：'+data[1].renew
            }, {
                value: data[2].renew,
                name: "本科生："+data[2].renew
            }, {
                value: data[3].renew,
                name: "研究生："+data[3].renew
            },
            ];
            echarts.util.each(originalData, function(item, index) {
                item.itemStyle = {
                    normal: {
                        color: colorList[index]
                    }
                };
            });
            var getlendrenew_student_typeoption = {
                animation:false,
                backgroundColor:'white',
                title: [
                    {
                        text: total.name,
                        left: '49%',
                        top: '45%',
                        textAlign: 'center',
                        textBaseline: 'middle',
                        textStyle: {
                            color: '#999',
                            fontWeight: 'normal',
                            fontSize: 20
                        }
                    },
                    {
                        text: total.value,
                        left: '49%',
                        top: '55%',
                        textAlign: 'center',
                        textBaseline: 'middle',
                        textStyle: {
                            color: '#666',
                            fontWeight: 'normal',
                            fontSize: 30
                        }
                    }],
                series: [{
                    hoverAnimation: false, //设置饼图默认的展开样式
                    radius: [80, 100],
                    name: 'pie',
                    type: 'pie',
                    selectedMode: 'single',
                    selectedOffset: 16, //选中是扇区偏移量
                    clockwise: true,
                    startAngle: 90,
                    label: {
                        normal: {
                            textStyle: {
                                fontSize: 16,
                                color: '#999'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            lineStyle: {
                                color: '#999',

                            }
                        }
                    },
                    data: originalData
                }]
            };
            var getlendrenew_student_type = echarts.init(document.getElementById('getlendrenew_student_type'));
            getlendrenew_student_type.setOption(getlendrenew_student_typeoption);
        }
    })
}
function geICdurationCountBy_year() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/geICdurationCountBy_year',
        dataType:'json',
        async:false,
        success:function (data) {
            var icdurationmonth = [];
            var idduration_times = [];
            for(var i=0;i<data.length;i++){
                icdurationmonth.push(data[i].month+'月');
                idduration_times.push(data[i].eread_times);
            }
            var sortData = sortByKey(data,'eread_times');
            $(".eread-info").find(".max-month").text(sortData[sortData.length-1].month);
            $(".eread-info").find(".max-num").text(sortData[sortData.length-1].eread_times);
            replace["eread_read_year"] = data[0].year;
            replace["img_read_year"] = data[0].year;
            replace["eread_read_month"] = sortData[sortData.length-1].month;
            replace["eread_read_time"] = sortData[sortData.length-1].eread_times;
            var geICdurationCountBy_year = echarts.init(document.getElementById('geICdurationCountBy_year'));
            var geICdurationCountBy_yearoption = {
                animation:false,
                backgroundColor:'white',
                tooltip : {
                    trigger: 'axis'
                },
                calculable : true,
                xAxis : [
                    {
                        name:'月',
                        type : 'category',
                        data : icdurationmonth
                    }
                ],
                yAxis : [
                    {
                        name:'次',
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'电子阅览室',
                        type:'bar',
                        data:idduration_times,
                        itemStyle: {
                            normal: {
                                color: function(params) {
                                    // build a color map as your need.
                                    var colorList = [
                                        '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                                        '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                                        '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                                    ];
                                    return colorList[params.dataIndex]
                                },label: {
                                    show: true,
                                    position: 'top',
                                    formatter: '{b}\n{c}'
                                }
                            }
                        }
                    }
                ]
            };
            geICdurationCountBy_year.setOption(geICdurationCountBy_yearoption);
        }
    });
}
function geICdurationBy_year(){
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/geICdurationBy_year',
        async:false,
        dataType:'json',
        success:function (data) {
            var colorList = [
                '#59c5a7', '#51b8fe', '#fa827d','#FFCC67'
            ];

            // 总和
            var total = {
                name: '总次数',
                value: data[0].lessone+data[0].onetotwo+data[0].twotofive+data[0].morefive
            }

            var originalData = [{
                value: data[0].lessone,
                name: '小于1小时：'+data[0].lessone
            }, {
                value: data[0].onetotwo,
                name: '1-2小时：'+data[0].onetotwo
            }, {
                value: data[0].twotofive,
                name: "2-5小时："+data[0].twotofive
            }, {
                value: data[0].morefive,
                name: "5小时以上："+data[0].morefive
            }
            ];
            echarts.util.each(originalData, function(item, index) {
                item.itemStyle = {
                    normal: {
                        color: colorList[index]
                    }
                };
            });
            var geICdurationBy_yearoption = {
                animation:false,
                backgroundColor:'white',
                title: [
                    {
                    text: total.name,
                    left: '49%',
                    top: '46%',
                    textAlign: 'center',
                    textBaseline: 'middle',
                    textStyle: {
                        color: '#999',
                        fontWeight: 'normal',
                        fontSize: 20
                    }
                },
                    {
                    text: total.value,
                    left: '49%',
                    top: '51%',
                    textAlign: 'center',
                    textBaseline: 'middle',
                    textStyle: {
                        color: '#666',
                        fontWeight: 'normal',
                        fontSize: 30
                    }
                }],
                grid:{
                    left:'15%',
                    right:'15%'
                },
                series: [{
                    hoverAnimation: false, //设置饼图默认的展开样式
                    radius: [100, 120],
                    name: 'pie',
                    type: 'pie',
                    selectedMode: 'single',
                    selectedOffset: 16, //选中是扇区偏移量
                    clockwise: true,
                    startAngle: 90,
                    label: {
                        normal: {
                            textStyle: {
                                fontSize: 14,
                                color: '#999'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            lineStyle: {
                                color: '#999'

                            }
                        }
                    },
                    data: originalData
                }]
            };
            var geICdurationBy_year = echarts.init(document.getElementById('geICdurationBy_year'));
            geICdurationBy_year.setOption(geICdurationBy_yearoption);
        }
    })
}
function geteread_hour() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getDeviceCount_Byhour',
        dataType:'json',
        async:false,
        success:function (data) {
            var ereadshour = [];
            var ereadshourtimes = [];
            for(var i=0;i<data.length;i++){
                ereadshour.push(data[i].hour);
                ereadshourtimes.push(data[i].ereads);
            }
            var max_ereads = Math.max.apply(Math,ereadshourtimes);
            var ereads_hour =ereadshour[ereadshourtimes.indexOf(max_ereads)];//电子阅览室的高峰期 lend_hour点-lend_hour+1点
            $(".eread-info").find(".max-hour").text(ereads_hour);
            $(".eread-info").find(".next-hour").text(ereads_hour+1);
            replace["ebook_spent_clock1"] = ereads_hour+"点";
            replace["ebook_spent_clock2"] = ereads_hour+1+"点";
            var geteread_hour = echarts.init(document.getElementById('geteread_hour'));
            var geteread_houroption = {
                animation:false,
                backgroundColor:'white',
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    top:'3%',
                    data: ['使用次数']
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: ereadshour,
                    splitLine: { //设置X轴的网格
                        show: true,
                        interval: 'auto'
                    },
                    axisLine: { //设置X轴的颜色
                        lineStyle: {
                            color: 'blue'
                        }
                    }
                },
                yAxis: {
                    type: 'value',
                    axisLine: { //设置y轴的颜色
                        lineStyle: {
                            color: 'blue'
                        }
                    }
                },
                series: [{
                    name: '使用次数',
                    type: 'line',
                    stack: '总量',
                    smooth: true, //点与点之间的幅度,false为直线
                    // symbol: 'circle',
                    // symbolSize: 5,
                    // showSymbol: true,   //是否显示点数据的圆点
                    // itemStyle: {    //设置折线的border颜色
                    //     normal: {
                    //         color: 'rgb(0,136,212)',
                    //         borderColor: 'rgba(0,136,212,0.2)',
                    //         borderWidth: 10
                    //     }
                    // },
                    label: { //设置点数据的提示
                        normal: {
                            show: true,
                            position: 'top'
                        }
                    },
                    data: ereadshourtimes,
                    markPoint: { //设置最大值和最小值
                        data: [{
                            type: 'max',
                            name: '最大值'
                        }, {
                            type: 'min',
                            name: '最小值'
                        }]
                    }

                }]
            };
            geteread_hour.setOption(geteread_houroption);
        }
    })
}
function getprintsCountBy_year() {
    $.ajax({
        type:'get',
        url:'../../printtimes/byyear',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data) {
            var year = data.year;
            var num = data.printtimes;
            var thisNum = num[num.length-1];
            var beforeNum = num[num.length-2];
            var variableNum = thisNum - beforeNum;
            if(variableNum<0){
                $(".total-print").find(".variable-type").text("减少");
                replace["print_amount_page2"] = "减少";
            }
            else if(variableNum>0){
                $(".total-print").find(".variable-type").text("增加");
                replace["print_amount_page2"] = "增加";
            }
            $(".total-print").find(".this-year").text(year[year.length-1]);
            $(".total-print").find(".this-num").text(num[num.length-1]);
            $(".total-print").find(".variable-num").text(Math.abs(variableNum));
            replace["print_amount_year"] = year[year.length-1];
            replace["print_amount_page1"] = num[num.length-1];
            replace["print_amount_page3"] = Math.abs(variableNum);
            var getprintsCountBy_year = echarts.init(document.getElementById('getprintsCountBy_year'));
            var getprintsCountBy_yearoption = {
                animation:false,
                backgroundColor:'white',
                color: ['#3398DB'],
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '3%',
                    right: '8%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis : [
                    {
                        name:'年',
                        type : 'category',
                        data : data.year,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis : [
                    {
                        // type : 'category',
                        // data : ['10','20','30','40'],
                        name:"人次",
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                series : [
                    {
                        name:'自主文印次数',
                        type:'bar',
                        barWidth: '40%',
                        data:data.printtimes
                    },

                ],
                label: {
                    normal: {
                        show: true,
                        position: 'top',
                        formatter: '{c}'
                    }
                },
                itemStyle: {
                    normal: {

                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(17, 168,171, 1)'
                        }, {
                            offset: 1,
                            color: 'rgba(17, 168,171, 0.1)'
                        }]),
                        shadowColor: 'rgba(0, 0, 0, 0.1)',
                        shadowBlur: 10
                    }
                }
            };
            getprintsCountBy_year.setOption(getprintsCountBy_yearoption);
        }
    });

}
function getprinttimesCountBy_year() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/gettypeprints',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var count = [];
            for(var i=0;i<data.print.length;i++){
                count.push({
                    value:data.print[i],
                    itemStyle:{
                        normal:{
                            color:'#C8B2F4'

                        }
                    }
                });
            }
            var getprinttimesCountBy_year = echarts.init(document.getElementById('getprinttimesCountBy_year'));
            var getprinttimesCountBy_yearoption = {
                animation:false,
                backgroundColor:'white',
                xAxis: [
                    {
                        name:'年',
                        type: 'category',
                        show:true,
                        data: data.year,
                        axisPointer: {
                            type: 'shadow'
                        },
                        axisTick: {
                            show: false
                        },
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        name: '打印次数',
                        /*min: 0,
                         max:100,
                         interval: 20,*/
                        axisLabel: {
                            formatter: '{value}'
                        },
                        axisTick: {
                            show: false
                        }
                    },

                ],
                grid:{
                    left:'12%',
                    right:'10%',
                    bottom:'10%'
                },
                series: [
                    {
                        /*name:'保障率',*/
                        type:'bar',
                        barWidth: '30%',
                        data:count,
                        label: {
                            normal: {
                                show: true,
                                position: 'top',
                                formatter: '{c}'
                            }
                        },
                    },

                    {
                        type:'line',
                        name:'占比',
                        data:data.print
                    }
                ],
            };
            getprinttimesCountBy_year.setOption(getprinttimesCountBy_yearoption);
        }
    });
}
function getcopytimesCountBy_year() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/gettypeprints',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var count = [];
            for(var i=0;i<data.copy.length;i++){
                count.push({
                    value:data.copy[i],
                    itemStyle:{
                        normal:{
                            color:'#32DADD'

                        }
                    }
                });
            }
            var getcopytimesCountBy_year = echarts.init(document.getElementById('getcopytimesCountBy_year'));
            var getcopytimesCountBy_yearoption = {
                backgroundColor:'white',
                animation:false,
                xAxis: [
                    {
                        name:'年',
                        type: 'category',
                        show:true,
                        data: data.year,
                        axisPointer: {
                            type: 'shadow'
                        },
                        axisTick: {
                            show: false
                        },
                    }
                ],

                yAxis: [
                    {
                        type: 'value',
                        name: '复印次数',
                        /*min: 0,
                         max:100,
                         interval: 20,*/
                        axisLabel: {
                            formatter: '{value}'
                        },
                        axisTick: {
                            show: false
                        }
                    },

                ],
                series: [
                    {
                        /*name:'保障率',*/
                        type:'bar',
                        barWidth: '30%',
                        data:count,
                        label: {
                            normal: {
                                show: true,
                                position: 'top',
                                formatter: '{c}'
                            }
                        },
                    },

                    {
                        type:'line',
                        name:'占比',
                        data:data.copy
                    }
                ],
            };
            getcopytimesCountBy_year.setOption(getcopytimesCountBy_yearoption);
        }
    });
}
function getscantimesCountBy_year() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/gettypeprints',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var count = [];
            for(var i=0;i<data.scan.length;i++){
                count.push({
                    value:data.scan[i],
                    itemStyle:{
                        normal:{
                            color:'#FF3292'

                        }
                    }
                });
            }
            var getscantimesCountBy_year = echarts.init(document.getElementById('getscantimesCountBy_year'));
            var getscantimesCountBy_yearoption = {
                animation:false,
                backgroundColor:'white',
                xAxis: [
                    {
                        name:'年',
                        type: 'category',
                        show:true,
                        data: data.year,
                        axisPointer: {
                            type: 'shadow'
                        },
                        axisTick: {
                            show: false
                        },
                    }
                ],

                yAxis: [
                    {
                        type: 'value',
                        name: '扫描次数',
                        /*min: 0,
                         max:100,
                         interval: 20,*/
                        axisLabel: {
                            formatter: '{value}'
                        },
                        axisTick: {
                            show: false
                        }
                    },

                ],
                series: [
                    {
                        /*name:'保障率',*/
                        type:'bar',
                        barWidth: '30%',
                        data:count,
                        label: {
                            normal: {
                                show: true,
                                position: 'top',
                                formatter: '{c}'
                            }
                        },
                    },

                    {
                        type:'line',
                        name:'占比',
                        data:data.scan
                    }
                ],
            };
            getscantimesCountBy_year.setOption(getscantimesCountBy_yearoption);
        }
    });
}
function getprints_hour() {
    $.ajax({
        type:'get',
        contentType:'application/json',
        url:'../../schoolReport/getDeviceCount_Byhour',
        dataType:'json',
        async:false,
        success:function (data) {
            var printshour = [];
            var printshourtimes = [];
            for(var i=0;i<data.length;i++){
                printshour.push(data[i].hour);
                printshourtimes.push(data[i].prints);
            }
            var max_prints = Math.max.apply(Math,printshourtimes);
            var prints_hour =printshour[printshourtimes.indexOf(max_prints)];//自助文印设备的高峰期 lend_hour点-lend_hour+1点
            $(".print-info").find(".max-hour").text(prints_hour);
            $(".print-info").find(".next-hour").text(parseInt(prints_hour) + 1);
            replace["print_day_clock1"] = prints_hour+"点";
            replace["print_day_clock2"] = parseInt(prints_hour) + 1+"点";
            var getprints_hour = echarts.init(document.getElementById('getprints_hour'));
            var getprints_houroption = {
                animation:false,
                backgroundColor:'white',
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    top:'5%',
                    data: ['自助文印次数']
                },
                grid: {
                    left: '2%',
                    right: '5%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: printshour,
                    splitLine: { //设置X轴的网格
                        show: true,
                        interval: 'auto'
                    },
                    axisLine: { //设置X轴的颜色
                        lineStyle: {
                            color: 'blue'
                        }
                    }
                },
                yAxis: {
                    type: 'value',
                    axisLine: { //设置y轴的颜色
                        lineStyle: {
                            color: 'blue'
                        }
                    }
                },
                series: [{
                    name: '自助文印次数',
                    type: 'line',
                    stack: '总量',
                    smooth: true, //点与点之间的幅度,false为直线
                    // symbol: 'circle',
                    // symbolSize: 5,
                    // showSymbol: true,   //是否显示点数据的圆点
                    // itemStyle: {    //设置折线的border颜色
                    //     normal: {
                    //         color: 'rgb(0,136,212)',
                    //         borderColor: 'rgba(0,136,212,0.2)',
                    //         borderWidth: 10
                    //     }
                    // },
                    label: { //设置点数据的提示
                        normal: {
                            show: true,
                            position: 'top'
                        }
                    },
                    data: printshourtimes,
                    markPoint: { //设置最大值和最小值
                        data: [{
                            type: 'max',
                            name: '最大值'
                        }, {
                            type: 'min',
                            name: '最小值'
                        }]
                    }

                }]
            };
            getprints_hour.setOption(getprints_houroption);
        }
    })
}
function readerLend() {
    $.get('../../schoolReport/getReder_booklendCount_Byyear',function (info) {
        //console.log(info)
        $(".reader-info").find(".max-name").text(info[0].name);
        $(".reader-info").find(".sec-name").text(info[1].name);
        $(".reader-info").find(".third-name").text(info[2].name);
        $(".reader-info").find(".max-num").text(info[0].all_lend_times);
        $(".reader-info").find(".sec-num").text(info[1].all_lend_times);
        $(".reader-info").find(".third-num").text(info[2].all_lend_times);
        replace["lend_reader_year1"] = nowyear;
        replace["lend_reader_name1"] = info[0].name;
        replace["lend_reader_name2"] = info[1].name;
        replace["lend_reader_name3"] = info[2].name;
        replace["lend_reader_times1"] = info[0].all_lend_times;
        replace["lend_reader_times2"] = info[1].all_lend_times;
        replace["lend_reader_times3"] = info[2].all_lend_times;
        replace["form_top10_year"] = nowyear;
        for(var i=0;i<info.length;i++){
            replace["1-"+(i+1)+"-1"] = info[i].account;
            replace["1-"+(i+1)+"-2"] = info[i].name;
            replace["1-"+(i+1)+"-3"] = info[i].academy;
            replace["1-"+(i+1)+"-4"] = info[i].all_lend_times;
        }
        var html = template('readerLend',{param:info});
        $(".reader-lend").html(html);
    })
}
function bookLend1() {
    $.get('../../schoolReport/getop20authorBy_year',function (info) {
        $(".book-info").find(".max-name").text(info[0].book_name);
        $(".book-info").find(".max-num").text(info[0].lend_times);
        replace["top_book_name"] = info[0].book_name;
        replace["top_book_times"] = info[0].lend_times;
        replace["form_numbertop15_year"] = info[0].year;
        var item = cutArray(info);
        var html = template('bookLend1',{param:item});
        for(var i=0;i<item.length;i++){
            replace["2-"+(i+1)+"-1"] = item[i].book_name;
            replace["2-"+(i+1)+"-2"] = item[i].author;
            replace["2-"+(i+1)+"-3"] = item[i].book_pubyear;
            replace["2-"+(i+1)+"-4"] = item[i].lend_times;
        }
        $(".book-lend1").html(html);
    })
}
function bookLend2() {
    $.get('../../schoolReport/getop20bookBy_year',function (info) {
        $(".book-info2").find(".max-name").text(info[0].book_name);
        replace["fav_book_name"] = info[0].book_name;
        replace["fav_book_author"] = info[0].author;
        replace["form_typetop15_year"] = info[0].year;
        var item = cutArray(info);
        var html = template('bookLend2',{param:item});
        for(var i=0;i<item.length;i++){
            replace["3-"+(i+1)+"-1"] = item[i].book_name;
            replace["3-"+(i+1)+"-2"] = item[i].author;
            replace["3-"+(i+1)+"-3"] = item[i].book_pubyear;
            replace["3-"+(i+1)+"-4"] = item[i].lend_times;
        }
        $(".book-lend2").html(html);
    })
}

function bookLend3() {
    $.get('../../schoolReport/getSingleBookLendTop100',function (info) {
        var data = [];
        for(var i = 0; i <info.bookName.length; i++){
           var basedata = new Object();
           basedata.index = i+1;
            basedata.publisher = info.publisher[i];
            basedata.times = info.bookLendTimes[i];
            basedata.bookAuthor = info.bookAuthor[i];
            basedata.bookName = info.bookName[i];
           data.push(basedata);
        }
        replace.top100 = data;
        var html = template('bookLend3',{param:data});
        $(".book-lend3").html(html);
    })
}

function staffLend() {
    $.get('../../schoolReport/getTeacherCount_BycountAndyear',function (info) {
        var item ={
            year:[],
            // data:[
            //     {name:'<10册',data1:info['<10册'][0].lend,data2:info['<10册'][1].lend,data3:info['<10册'][2].lend},
            //     {name:'11-20册',data1:info['11-20册'][0].lend,data2:info['11-20册'][1].lend,data3:info['11-20册'][2].lend},
            //     {name:'21-30册',data1:info['21-30册'][0].lend,data2:info['21-30册'][1].lend,data3:info['21-30册'][2].lend},
            //     {name:'31-50册',data1:info['31-50册'][0].lend,data2:info['31-50册'][1].lend,data3:info['31-50册'][2].lend},
            //     {name:'51-100册',data1:info['51-100册'][0].lend,data2:info['51-100册'][1].lend,data3:info['51-100册'][2].lend},
            //     {name:'101-200册',data1:info['101-200册'][0].lend,data2:info['101-200册'][1].lend,data3:info['101-200册'][2].lend},
            //     {name:'201-300册',data1:info['201-300册'][0].lend,data2:info['201-300册'][1].lend,data3:info['201-300册'][2].lend},
            //     {name:'>300册',data1:info['>300册'][0].lend,data2:info['>300册'][1].lend,data3:info['>300册'][2].lend}
            // ],
            dat:[]
        };
        getArray(info,item.dat,'<10册');
        getArray(info,item.dat,'11-20册');
        getArray(info,item.dat,'21-30册');
        getArray(info,item.dat,'31-50册');
        getArray(info,item.dat,'31-50册');
        getArray(info,item.dat,'51-100册');
        getArray(info,item.dat,'101-200册');
        getArray(info,item.dat,'201-300册');
        getArray(info,item.dat,'>300册');
        for(var i=0;i<info['11-20册'].length;i++){
            item.year.push(info['11-20册'][i].year);
        }
        var html = template('staffLend',{param:item});
        console.log(2);
        console.log(item);
        for(var i=1;i<=item.dat.length;i++){
            replace["4-"+i+"-1"] = item.dat[i-1].data1;
            replace["4-"+i+"-2"] = item.dat[i-1].data2;
            replace["4-"+i+"-3"] = item.dat[i-1].data3;
        }
        replace["chart_year1"] = item.year[0];
        replace["chart_year2"] = item.year[1];
        replace["chart_year3"] = item.year[2];
        $(".staff-lend").html(html);
    })
}
function cutArray(array) {
    var data=[];
    for(var i=0;i<15;i++){
        data.push(array[i]);
    }
    return data;
}
function getArray(info,data,txt) {
    if(info[txt].length==3){
        data.push({name:txt,data1:info[txt][0].lend,data2:info[txt][1].lend,data3:info[txt][2].lend})
    }
    return data;
}
function Max(arr){
    var obj = {
        p:0,
        num:arr[0]
    };
    for(var i=0;i<arr.length;i++){
        if(obj.num < arr[i]){
            obj.num = arr[i];
            obj.p = i;
        }
    }
    return obj;
}
function Sum(arr) {
    var s = 0;
    for (var i=arr.length-1; i>=0; i--) {
        s += arr[i];
    }
    return s;
}
function sortByKey(array,key){
    return array.sort(function(a,b){
        var x=a[key];
        var y=b[key];
        return ((x<y)?-1:((x>y)?1:0));
    });
}



 function getCollectionOverall(){
     var dataAll=[];
     var yAxisData=[];
     var piedata=[];
     $.ajax({
     type:'get',
     url:'../../schoolReport/getCollectionOverall',
     contentType: 'application/json',
     async:false,
     dataType: 'json',
     success: function(data, textStatus, jqXHR){
         var html = template('getCollectionOveralltable',{param:data.object});
         $(".getCollectionOveralltable").html(html);
         for(var i=0;i<data.object.length;i++){
             replace["13-"+(i+1)+"-1"] = data.object[i].stack;
             replace["13-"+(i+1)+"-2"] = data.object[i].amount;
         }
     dataAll=data.amount;
     yAxisData=data.stack;
     for(var i=0;i<dataAll.length;i++){
        // console.log({ value:dataAll[i],name:yAxisData[i]})
         piedata.push({ value:dataAll[i],name:yAxisData[i]});
     }
       //  console.log(piedata)
         var getCollectionOverall = echarts.init(document.getElementById('getCollectionOverall'));
         var getCollectionOveralloption = {
             animation:false,
         backgroundColor: '#0f375f',
         title:[
         {text:"各馆藏书占比",x: '2%', y: '1%',textStyle:{color:"#fff",fontSize:"14"}},
         {text:"各馆藏书TOP10",x: '40%', y: '1%',textStyle:{color:"#fff",fontSize:"14"}},

         ],
         grid: [
         {x: '65%', y: '7%', width: '30%', height: '90%'},
         ],
         tooltip: {
         formatter: '{b} ({c})'
         },
         xAxis: [
         {gridIndex: 0, axisTick: {show:false},axisLabel: {show:false},splitLine: {show:false},axisLine: {show:false }},
         ],
         yAxis: [
         {  gridIndex: 0, interval:0,data:yAxisData,
         axisTick: {show:false}, axisLabel: {show:true},splitLine: {show:false},
         axisLine: {show:true,lineStyle:{color:"#6173a3"}},
         }
         ],
         series: [
         {
         name: '各馆藏书占比',
         type: 'pie',
         radius : '30%',
         center: ['25%', '50%'],
         color:['#86c9f4','#4da8ec','#3a91d2','#005fa6','#315f97'],
         data:piedata,
         label:{normal:{show:true,position:'outside',fontSize:12}},
         labelLine:{normal:{show:true} },
         itemStyle: {normal: {label:{ show: true,  formatter: '({d}%)', textStyle:{color:'#B1B9D3'}} },},
         },

         {
         name: '各馆藏书TOP10',
         type: 'bar',xAxisIndex: 0,yAxisIndex: 0,barWidth:'45%',
         itemStyle:{normal:{color:'#86c9f4'}},
         label:{normal:{show:true, position:"right",textStyle:{color:"#9EA7C4"}}},
         data: dataAll,
         },

         ]
         };
         getCollectionOverall.setOption(getCollectionOveralloption);
     }
     });


 }

function getCollectionNewAdded(){
    var dataAll=[];
    var yAxisData=[];
    var piedata=[];
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionNewAdded',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var html = template('getCollectionOveralltable',{param:data.object});
            $(".getCollectionNewAddedtable").html(html);
            for(var i=0;i<data.object.length;i++){
                replace["10-"+(i+1)+"-1"] = data.object[i].stack;
                replace["10-"+(i+1)+"-2"] = data.object[i].amount;
            }
            dataAll=data.amount;
            yAxisData=data.stack;
            for(var i=0;i<dataAll.length;i++){
                // console.log({ value:dataAll[i],name:yAxisData[i]})
                piedata.push({ value:dataAll[i],name:yAxisData[i]});
            }
            //  console.log(piedata)
            var getCollectionNewAdded = echarts.init(document.getElementById('getCollectionNewAdded'));
            var getCollectionNewAddedoption = {
                animation:false,
                backgroundColor: '#0f375f',
                title:[
                    {text:"各馆新增藏书占比",x: '2%', y: '1%',textStyle:{color:"#fff",fontSize:"14"}},
                    {text:"各馆新增藏书TOP10",x: '40%', y: '1%',textStyle:{color:"#fff",fontSize:"14"}},

                ],
                grid: [
                    {x: '65%', y: '7%', width: '30%', height: '90%'},
                ],
                tooltip: {
                    formatter: '{b} ({c})'
                },
                xAxis: [
                    {gridIndex: 0, axisTick: {show:false},axisLabel: {show:false},splitLine: {show:false},axisLine: {show:false }},
                ],
                yAxis: [
                    {  gridIndex: 0, interval:0,data:yAxisData,
                        axisTick: {show:false}, axisLabel: {show:true},splitLine: {show:false},
                        axisLine: {show:true,lineStyle:{color:"#6173a3"}},
                    }
                ],
                series: [
                    {
                        name: '各馆新增藏书占比',
                        type: 'pie',
                        radius : '30%',
                        center: ['25%', '50%'],
                        color:['#86c9f4','#4da8ec','#3a91d2','#005fa6','#315f97'],
                        data:piedata,
                        label:{normal:{show:true,position:'outside',fontSize:12}},
                        labelLine:{normal:{show:true} },
                        itemStyle: {normal: {label:{ show: true,  formatter: '({d}%)', textStyle:{color:'#B1B9D3'}} },},
                    },

                    {
                        name: '各馆新增藏书TOP10',
                        type: 'bar',xAxisIndex: 0,yAxisIndex: 0,barWidth:'45%',
                        itemStyle:{normal:{color:'#86c9f4'}},
                        label:{normal:{show:true, position:"right",textStyle:{color:"#9EA7C4"}}},
                        data: dataAll,
                    },

                ]
            };
            getCollectionNewAdded.setOption(getCollectionNewAddedoption);
        }
    });


}

function getCollectionNewAddedByCate(){
    var booktype=[];
    var category=[];
    var servicedata=[];
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionNewAddedByCate',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var html = template('getCollectionNewAddedByCatetable',{param:data.ob});
            $(".getCollectionNewAddedByCatetable").html(html);
            for(var i=0;i<data.ob.length;i++){
                replace["11-"+(i+2)+"-1"] = data.ob[i].category;
                replace["11-"+(i+2)+"-2"] = data.ob[i].zwts;
                replace["11-"+(i+2)+"-3"] = data.ob[i].xwlw;
                replace["11-"+(i+2)+"-4"] = data.ob[i].tcts;
                replace["11-"+(i+2)+"-5"] = data.ob[i].gtts;
                replace["11-"+(i+2)+"-6"] = data.ob[i].zwzs;
                replace["11-"+(i+2)+"-7"] = data.ob[i].wkhdb;
                replace["11-"+(i+2)+"-8"] = data.ob[i].qt;
                replace["11-"+(i+2)+"-9"] = data.ob[i].wwts;

            }
            for(var i=0;i<data.booktype.length;i++){
                replace["11-1-"+(i+2)] = data.booktype[i];
            }
            booktype=data.booktype;
            category=data.category;
            for(var key in data){
                if(key!="booktype"&&key!="category"&&key!="ob")
                {
                    servicedata.push({ name: key,type: 'bar',data:data[key]});
                }
            }
            var getCollectionNewAddedByCate = echarts.init(document.getElementById('getCollectionNewAddedByCate'));
            var getCollectionNewAddedByCateoption = {
                animation:false,
                tooltip: {
                    trigger: 'axis',
                    axisPointer: { // 坐标轴指示器，坐标轴触发有效
                        type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    data:booktype,
                    align: 'right',
                    right: 10
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [{
                    type: 'category',
                    data: category
                }],
                yAxis: [{
                    type: 'value',
                    name: '总数(本)',
                    axisLabel: {
                        formatter: '{value}'
                    }
                }],
                series: servicedata
            };
            getCollectionNewAddedByCate.setOption(getCollectionNewAddedByCateoption);
        }
    });


}

function getCollectionTuShuNewAddedByCatetable(){
    var booktype=[];
    var category=[];
    var servicedata=[];
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionTuShuNewAddedByCate',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var html = template('getCollectionTuShuNewAddedByCatetable',{param:data.ob});
            $(".getCollectionTuShuNewAddedByCatetable").html(html);
            console.log(data.ob);
            for(var i=0;i<data.ob.length;i++){
                replace["12-"+(i+2)+"-1"] = data.ob[i].category;
                replace["12-"+(i+2)+"-2"] = data.ob[i].zwts;
                replace["12-"+(i+2)+"-3"] = data.ob[i].xwlw;
                replace["12-"+(i+2)+"-4"] = data.ob[i].tcts;
                replace["12-"+(i+2)+"-5"] = data.ob[i].gtts;
                replace["12-"+(i+2)+"-6"] = data.ob[i].zwzs;
                replace["12-"+(i+2)+"-7"] = data.ob[i].wkhdb;
                replace["12-"+(i+2)+"-8"] = data.ob[i].qt;
                replace["12-"+(i+2)+"-9"] = data.ob[i].wwts;

            }
            for(var i=0;i<data.booktype.length;i++){
                replace["12-1-"+(i+2)] = data.booktype[i];
            }
            booktype=data.booktype;
            category=data.category;
            for(var key in data){
                if(key!="booktype"&&key!="category"&&key!="ob")
                {
                    servicedata.push({ name: key,type: 'bar',data:data[key]});
                }
            }
            var getCollectionTuShuNewAddedByCate = echarts.init(document.getElementById('getCollectionTuShuNewAddedByCate'));
            var getCollectionTuShuNewAddedByCateoption = {
                animation:false,
                tooltip: {
                    trigger: 'axis',
                    axisPointer: { // 坐标轴指示器，坐标轴触发有效
                        type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    data:booktype,
                    align: 'right',
                    right: 10
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [{
                    type: 'category',
                    data: category
                }],
                yAxis: [{
                    type: 'value',
                    name: '总数(本)',
                    axisLabel: {
                        formatter: '{value}'
                    }
                }],
                series: servicedata
            };
            getCollectionTuShuNewAddedByCate.setOption(getCollectionTuShuNewAddedByCateoption);
        }
    });


}

function getCollectionTuShuNewAddedByCate(){
    var booktype=[];
    var category=[];
    var servicedata=[];
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionTuShuNewAddedByCate',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            var html = template('getCollectionTuShuNewAddedByCatetable',{param:data.ob});
            $(".getCollectionTuShuNewAddedByCatetable").html(html);
            console.log(data.ob);
            for(var i=0;i<data.ob.length;i++){
                replace["12-"+(i+2)+"-1"] = data.ob[i].category;
                replace["12-"+(i+2)+"-2"] = data.ob[i].zwts;
                replace["12-"+(i+2)+"-3"] = data.ob[i].xwlw;
                replace["12-"+(i+2)+"-4"] = data.ob[i].tcts;
                replace["12-"+(i+2)+"-5"] = data.ob[i].gtts;
                replace["12-"+(i+2)+"-6"] = data.ob[i].zwzs;
                replace["12-"+(i+2)+"-7"] = data.ob[i].wkhdb;
                replace["12-"+(i+2)+"-8"] = data.ob[i].qt;
                replace["12-"+(i+2)+"-9"] = data.ob[i].wwts;

            }
            for(var i=0;i<data.booktype.length;i++){
                replace["12-1-"+(i+2)] = data.booktype[i];
            }
            booktype=data.booktype;
            category=data.category;
            for(var key in data){
                if(key!="booktype"&&key!="category"&&key!="ob")
                {
                    servicedata.push({ name: key,type: 'bar',data:data[key]});
                }
            }
            var getCollectionTuShuNewAddedByCate = echarts.init(document.getElementById('getCollectionTuShuNewAddedByCate'));
            var getCollectionTuShuNewAddedByCateoption = {
                animation:false,
                tooltip: {
                    trigger: 'axis',
                    axisPointer: { // 坐标轴指示器，坐标轴触发有效
                        type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    data:booktype,
                    align: 'right',
                    right: 10
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [{
                    type: 'category',
                    data: category
                }],
                yAxis: [{
                    type: 'value',
                    name: '总数(本)',
                    axisLabel: {
                        formatter: '{value}'
                    }
                }],
                series: servicedata
            };
            getCollectionTuShuNewAddedByCate.setOption(getCollectionTuShuNewAddedByCateoption);
        }
    });


}

function getCollectionWaiWenNewAddedByCate(){
    var lengthdata=[];
    var servicedata=[];
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionWaiWenNewAddedByCate',
        contentType: 'application/json',
        async:false,
        dataType: 'json',
        success: function(data, textStatus, jqXHR){
            //var html = template('getCollectionTuShuNewAddedByCatetable',{param:data.ob});
            //$(".getCollectionTuShuNewAddedByCatetable").html(html)
            lengthdata=data.category;

            var center1= ['10%', '30%'];
            var center2= ['30%', '30%'];
            var center3=['50%', '30%'];
            var center4= ['70%', '30%'];
            var center5= ['90%', '30%'];
            var center6=['10%', '70%'];
            var center7= ['30%', '70%'];
            var center8=['50%', '70%'];
            var center9= ['70%', '70%'];
            var center10=['90%', '70%'];
            var centers=[center1,center2,center3,center4,center5,center6,center7,center8,center9,center10];i
            var labelTop = {
                normal : {
                    label : {
                        show : true,
                        position : 'center',
                        formatter : '{b}',
                        textStyle: {
                            baseline : 'bottom'
                        }
                    },
                    labelLine : {
                        show : false
                    }
                }
            };
            var labelFromatter = {
                normal : {
                    label : {
                        formatter : function (params){
                            return  ((data['count'][0] - params.value)/data['count'][0]).toFixed(2)
                        },
                        textStyle: {
                            baseline : 'top'
                        }
                    }
                },
            }
            var labelBottom = {
                normal : {
                    color: '#ccc',
                    label : {
                        show : true,
                        position : 'center'
                    },
                    labelLine : {
                        show : false
                    }
                },
                emphasis: {
                    color: 'rgba(0,0,0,0)'
                }
            };
            var radius = [40, 55];
            for(var i=0;i<data["category"].length;i++){
                    servicedata.push(
                        {
                            type : 'pie',
                            center : centers[i],
                            radius : radius,
                            itemStyle : labelFromatter,
                            data : [
                                {name:'other', value:data['count'][0]-data['外文图书'][i], itemStyle : labelBottom},
                                {name:data['category'][i], value:data['外文图书'][i],itemStyle : labelTop}
                            ]
                        }
                    );
            }
            var getCollectionWaiWenNewAddedByCateoption = {
                animation:false,
                legend: {
                    x : 'center',
                    y : 'center',
                    data:lengthdata
                },
               /* toolbox: {
                    show : true,
                    feature : {
                        dataView : {show: true, readOnly: false},
                        magicType : {
                            show: true,
                            type: ['pie', 'funnel'],
                            option: {
                                funnel: {
                                    width: '20%',
                                    height: '30%',
                                    itemStyle : {
                                        normal : {
                                            label : {
                                                formatter : function (params){
                                                    return 'other\n' + params.value + '%\n'
                                                },
                                                textStyle: {
                                                    baseline : 'middle'
                                                }
                                            }
                                        },
                                    }
                                }
                            }
                        },
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },*/
                series : servicedata
            };
            var getCollectionWaiWenNewAddedByCate = echarts.init(document.getElementById('getCollectionWaiWenNewAddedByCate'));
            getCollectionWaiWenNewAddedByCate.setOption(getCollectionWaiWenNewAddedByCateoption);
        }
    });


}

function getCollectionAmountType() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionAmountType?'+nowyear,
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data){
            var param = [];
            var amount1 = 0;
            var amount2 = 0;
            var amount3 = 0;
            for(var i=0;i<data.stack.length;i++){
                var basedata = new Object();
                basedata.stack=data.stack[i];
                basedata.amounttype=data.amounttype[i];
                if(data.stackpubyear.indexOf(data.stack[i])!=-1){
                    basedata.amounttypePubyear = data.amounttypePubyear[data.stackpubyear.indexOf(data.stack[i])];
                }
                else{
                    basedata.amounttypePubyear=0;
                }
                if(data.stackthisyear.indexOf(data.stack[i])!=-1){
                    basedata.amounttypeYear = data.amounttypeYear[data.stackthisyear.indexOf(data.stack[i])];
                }
                else{
                    basedata.amounttypeYear=0;
                }
                amount1+=basedata.amounttype;
                amount2+=basedata.amounttypePubyear;
                amount3+=basedata.amounttypeYear;
                param.push(basedata);
                replace["5-"+(i+1)+"-1"] = basedata.stack;
                replace["5-"+(i+1)+"-2"] = basedata.amounttype;
                replace["5-"+(i+1)+"-4"] = basedata.amounttypePubyear;
                replace["5-"+(i+1)+"-3"] = basedata.amounttypeYear;
            }
            var html = template('getCollectionAmountType',{param:param,amount1:amount1,amount2:amount2,amount3:amount3});
            replace["5-36-2"] = amount1;
            replace["5-36-3"] = amount2;
            replace["5-36-4"] = amount3;
            $(".getCollectionAmountTypeTable").html(html);
            $(".collectionyear").text(nowyear);
            $(".amount1").text(amount1);
            $(".amount2").text(amount2);
            $(".amount3").text(amount3);
            replace["collection-year"] = nowyear;
            replace["collection-amount-type"] = amount1;
            replace["collection-amount-add"] = amount2;
            replace["collection-amount-pub"] = amount3;

        }
    })
}

function getCollectionByStackAndBooktype() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionByStackAndBooktype',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data){
            var param = [];
            for(var i=0;i<data.stack.length;i++){
                var basedata = new Object();
                basedata.stack = data.stack[i];
                var arr = new Array;
                var amount=0;
                for(var j=0;j<data.bookType.length;j++){
                    arr.push(data.amounttype[i*data.bookType.length+j]);
                    replace["6-"+(i+2)+"-"+(j+2)] = data.amounttype[i*data.bookType.length+j];
                    amount+=data.amounttype[i*data.bookType.length+j];
                }
                basedata.amounttype = arr;
                basedata.amount=amount;
                replace["6-"+(i+2)+"-"+"1"] = data.stack[i];
                replace["6-"+(i+2)+"-"+(data.bookType.length+2)] = amount;
                param.push(basedata);
            }
            var arr1 = [];
            for(var i=0;i<param.length;i++){
                for(var j=0;j<param[i].amounttype.length;j++){
                    if(i==0){
                        arr1[j] = param[i].amounttype[j];
                    }
                    else{
                        arr1[j]+=param[i].amounttype[j];
                    }
                }
                if(i==0){
                    arr1[param[i].amounttype.length] = param[i].amount;
                }
                else{
                    arr1[param[i].amounttype.length] += param[i].amount;
                }
            }
            for(var i = 0;i<data.bookType.length;i++){
                replace["6-1"+"-"+(i+2)] = data.bookType[i];
            }
            for(var i=0;i<arr1.length;i++){
                replace["6-"+(data.stack.length+2)+"-"+(i+2)] = arr1[i];
            }
            var html = template('getCollectionByStackAndBooktype',{param:param,bookType:data.bookType,arr1:arr1});
            $(".getCollectionByStackAndBooktype").html(html);
        }
    })
}

function getCollectionByPubyear() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionByPubyear',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data){
            var param = [];
            var typechart=[];
            var numberchart=[];
            var yeardata = [];
            var amounttype = 0;
            var amountnumber = 0;
            for(var key in data){
                var basedata = new Object();
                var typechartdata = new Object();
                var numberchartdata = new Object();
                var index = 0;
                switch(key){
                    case "-1919" : index=0;break;
                    case "1920-1929" : index=1;break;
                    case "1930-1939" : index=2;break;
                    case "1940-1949" : index=3;break;
                    case "1950-1959" : index=4;break;
                    case "1960-1969" : index=5;break;
                    case "1970-1979" : index=6;break;
                    case "1980-1989" : index=7;break;
                    case "1990-1999" : index=8;break;
                    case "2000-2009" : index=9;break;
                    case "2010-" : index=10;break;
                    case "不详" : index=11;break;
                }
                basedata.year = key;
                basedata.amounttype = data[key].amounttype;
                basedata.amountnumber = data[key].amountnumber;
                amounttype += data[key].amounttype;
                amountnumber += data[key].amountnumber;
                param[index] = basedata;
                yeardata[index] = key;
                typechartdata.name = key;
                typechartdata.value = data[key].amounttype;
                typechart[index] = typechartdata;
                numberchartdata.name = key;
                numberchartdata.value = data[key].amountnumber;
                numberchart[index] = numberchartdata;
            }
            for(var i=0;i<param.length;i++){
                param[i].typepecent = parseFloat(param[i].amounttype/amounttype)*100;
                param[i].numberpecent = parseFloat(param[i].amountnumber/amountnumber)*100;
                param[i].typepecent = param[i].typepecent.toFixed(2)+"%";
                param[i].numberpecent = param[i].numberpecent.toFixed(2)+"%";
                replace["7-"+(i+1)+"-1"] = param[i].amounttype;
                replace["7-"+(i+1)+"-2"] = param[i].typepecent;
                replace["7-"+(i+1)+"-3"] = param[i].amountnumber;
                replace["7-"+(i+1)+"-4"] = param[i].numberpecent;
            }
            replace["7-"+(param.length+1)+"-1"] = amounttype;
            replace["7-"+(param.length+1)+"-3"] = amountnumber;
            var html = template('getCollectionByPubyear',{param:param,amounttype:amounttype,amountnumber:amountnumber});
            $(".getCollectionByPubyear").html(html);
            var typeoption = {
                animation:false,
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c} ({d}%)",
                },
                legend: {
                    y:'bottom',
                    itemWidth: 14,
                    itemHeight: 14,
                    align: 'left',
                    data:yeardata
                },
                series: [
                    {
                        name:'图书出版年发布（种）',
                        type:'pie',
                        hoverAnimation: false,
                        legendHoverLink:false,
                        radius: ['40%', '42%'],
                        color: ['#CD0000','#FFEC8B','#0000CD','#FF4500','#FF3E96','#d74e67', '#0092ff', '#eba954', '#21b6b9','#60a900','#01949b',' #f17677'],
                        label: {
                            normal: {
                                position: 'inner'
                            }
                        },
                        labelLine: {
                            normal: {
                                show: false
                            },

                        },
                        tooltip: {
                            show:false,


                        },
                    },
                    {
                        name:'图书出版年发布（种）',
                        type:'pie',
                        radius: ['42%', '55%'],
                        color: ['#CD0000','#FFEC8B','#0000CD','#FF4500','#FF3E96','#d74e67', '#0092ff', '#eba954', '#21b6b9','#60a900','#01949b',' #f17677'],
                        label: {
                            normal: {
                                formatter: '{b}\n{d}%'
                            },

                        },
                        data:typechart
                    }
                ]
            };

            var numberoption = {
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c} ({d}%)",
                },
                legend: {
                    y:'bottom',
                    itemWidth: 14,
                    itemHeight: 14,
                    align: 'left',
                    data:yeardata
                },
                series: [
                    {
                        name:'图书出版年发布（册）',
                        type:'pie',
                        hoverAnimation: false,
                        legendHoverLink:false,
                        radius: ['40%', '42%'],
                        color: ['#CD0000','#FFEC8B','#0000CD','#FF4500','#FF3E96','#d74e67', '#0092ff', '#eba954', '#21b6b9','#60a900','#01949b',' #f17677'],
                        label: {
                            normal: {
                                position: 'inner'
                            }
                        },
                        labelLine: {
                            normal: {
                                show: false
                            },

                        },
                        tooltip: {
                            show:false,
                        },
                    },
                    {
                        name:'图书出版年发布（册）',
                        type:'pie',
                        radius: ['42%', '55%'],
                        color: ['#CD0000','#FFEC8B','#0000CD','#FF4500','#FF3E96','#d74e67', '#0092ff', '#eba954', '#21b6b9','#60a900','#01949b',' #f17677'],
                        label: {
                            normal: {
                                formatter: '{b}\n{d}%'
                            },

                        },
                        data:numberchart
                    }
                ]
            };
            var typechart = echarts.init(document.getElementById("typechart"));
            var typenumber = echarts.init(document.getElementById("typenumber"));
            typechart.setOption(typeoption);
            typenumber.setOption(numberoption);
        }
    });
}

function getCollectionBycategory() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/getCollectionBycategory',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data){
            var arr = [];
            var arr1 = [];
            var seriestype = [];
            var seriesnumber = [];
            for(var i=0;i<data.bookType.length;i++){
                arr[i] = [];
                arr1[i] = [];
                for(var j=0;j<data.category.length;j++){
                    arr[i].push(data.amounttype[i*data.category.length+j]);
                    arr1[i].push(data.amountnumber[i*data.category.length+j]);
                }
            }
            var itemcolor = ['#FF7F0E','#2CA02C','#6ca7e2','#00CCFF','#915872','#3077b7','#9a8169','#3f8797'];
            for(var i=0;i<arr.length;i++){
                seriestype.push({
                    name: data.bookType[i],
                    type: 'bar',
                    stack: '总量',
                    itemStyle:{
                        normal:{
                            color:itemcolor[i]
                        }
                    },
                    label: {
                        normal: {
                            show: false,
                            position: 'insideRight'
                        }
                    },
                    data: arr[i]
                });
                seriesnumber.push({
                    name: data.bookType[i],
                    type: 'bar',
                    stack: '总量',
                    itemStyle:{
                        normal:{
                            color:itemcolor[i]
                        }
                    },
                    label: {
                        normal: {
                            show: false,
                            position: 'insideRight'
                        }
                    },
                    data: arr1[i]
                });
            }
            var typeoption = {
                animation:false,
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    data: data.bookType
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis:  {
                    type: 'value'
                },
                yAxis: {
                    type: 'category',
                    data: data.category
                },
                series: seriestype
            };
            var numberoption = {
                animation:false,
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                legend: {
                    data: data.bookType
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis:  {
                    type: 'value'
                },
                yAxis: {
                    type: 'category',
                    data: data.category
                },
                series: seriesnumber
            };
            var typechart = echarts.init(document.getElementById("getCollectionBycategorytype"));
            typechart.setOption(typeoption);
            var numberchart = echarts.init(document.getElementById("getCollectionBycategorynumber"));
            numberchart.setOption(numberoption);
        }
    });
}

function getTop10category(){
    $.ajax({
        type:'get',
        url:'../../schoolReport/getTop10category',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data){
            var param = [];
            for(var i=0;i<data.category.length;i++){
                replace["8-"+(i+1)+"-1"] = data.category[i];
                replace["8-"+(i+1)+"-2"] = data.amounttype[i];
                param.push({
                    "category" : data.category[i],
                    "amounttype" : data.amounttype[i]
                });
            }
            var html = template('getTop10category',{param:param});
            $(".getTop10category").html(html);
        }
    });
}

//  小章 以下是小章代码

function getBookLendByAcademy() {
    $.ajax({
        type:'get',
        url:'../../schoolReport/getYearTop3CategoryByAcademy',
        contentType:'application/json',
        async:false,
        dataType:'json',
        success:function (data) {
            document.getElementById("ThirdAcademyTitle").innerHTML =data["3"].readerAcademy + "借阅分布";
            replace["img_academy_top3title"] = data["3"].readerAcademy + "借阅分布";
            var getprintsCountBy_year3 = echarts.init(document.getElementById('getBookLendByAcademyThird'));
            var getBookLendByAcademyThird = {
              //  color: ['#000000'],
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '6%',
                    right: '6%',
                    bottom: '6%',
                    containLabel: true
                },
                xAxis : [
                    {
                        name : '种类',
                        type : 'category',
                        data : data["3"].bookCategory,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis : [
                    {
                        name : '人次',
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:' 人次',
                        type:'bar',
                        barWidth: '60%',
                        data : data["3"].categoryAmount,
                        itemStyle:{
                            normal:{
                                color:'#3398DB'
                            }
                        },
                        label: {
                            normal: {
                                color: ['#000000'],
                                show: true,
                                position: 'top',
                                formatter: '{c}'
                            }
                        },
                    }
                ]
            };
            getprintsCountBy_year3.setOption(getBookLendByAcademyThird);
            document.getElementById("FirstAcademyTitle").innerHTML =data["1"].readerAcademy + "借阅分布";
            replace["img_academy_top1title"] = data["1"].readerAcademy + "借阅分布";
            var getprintsCountBy_year1 = echarts.init(document.getElementById('getBookLendByAcademyFirst'));
            var getBookLendByAcademyFirst = {
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '6%',
                    right: '6%',
                    bottom: '6%',
                    containLabel: true
                },
                xAxis : [
                    {
                        name : '种类',
                        type : 'category',
                        data : data["1"].bookCategory,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis : [
                    {
                        name : '人次',
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:' 人次',
                        type:'bar',
                        barWidth: '60%',
                        data : data["1"].categoryAmount,
                        itemStyle:{
                            normal:{
                                color:'#FFC125'
                            }
                        },
                        label: {
                            normal: {
                                color: ['#000000'],
                                show: true,
                                position: 'top',
                                formatter: '{c}'
                            }
                        },
                    }
                ]
            };
            getprintsCountBy_year1.setOption(getBookLendByAcademyFirst);
            document.getElementById("SecondAcademyTitle").innerHTML =data["2"].readerAcademy + "借阅分布";
            replace["img_academy_top2title"] = data["2"].readerAcademy + "借阅分布";
            var getprintsCountBy_year2 = echarts.init(document.getElementById('getBookLendByAcademySecond'));
            var getBookLendByAcademySecond = {
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '6%',
                    right: '6%',
                    bottom: '6%',
                    containLabel: true
                },
                xAxis : [
                    {
                        name : '种类',
                        type : 'category',
                        data : data["2"].bookCategory,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis : [
                    {
                        name : '人次',
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:' 人次',
                        type:'bar',
                        barWidth: '60%',
                        data : data["2"].categoryAmount,
                        itemStyle:{
                            normal:{
                                color:'#9B30FF'
                            }
                        },
                        label: {
                            normal: {
                                color: ['#000000'],
                                show: true,
                                position: 'top',
                                formatter: '{c}'
                            }
                        },
                    }
                ]
            };
            getprintsCountBy_year2.setOption(getBookLendByAcademySecond);
        }
    });

}


