<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>주차장 찾기</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
    <div class="search-container">
        <input type="text" id="searchInput" placeholder="장소 검색" value="${keyword}">
        <button onclick="search()" id="searchBtn">검색</button>
    </div>
    
   <div id="map"></div>
    <div id="sidebar">
        <h2>주차장 리스트</h2>
        <ul id="markerList"></ul>
    </div>

    <script>
        var map;
        var markers = [];

        function initMap() {
            var mapElement = document.getElementById('map');
            var mapOptions = {
                center: { lat: 37.5665, lng: 126.9780 },  
                zoom: 10  
            };
            map = new google.maps.Map(mapElement, mapOptions);

            var arrayList = [
                <c:forEach var="parking" items="${arrayList}">
                    {
                        lat: <c:out value="${parking.parking_latitude}" />,
                        lng: <c:out value="${parking.parking_longitude}" />,
                        name: '<c:out value="${parking.parking_name}" />',
                        address: '<c:out value="${parking.parking_address}" />',
                        base_fee: '<c:out value="${parking.parking_base_fee}" />',
                        hourly_fee: '<c:out value="${parking.parking_hourly_rate}" />',
                        type: '<c:out value="${parking.parking_type}" />'
                    },
                </c:forEach>
            ];

            for (var i = 0; i < arrayList.length; i++) {
                addMarker(arrayList[i]);
            }
        }

        function addMarker(parking) {
            var marker = new google.maps.Marker({
                position: { lat: parking.lat, lng: parking.lng },
                map: map,
                title: parking.name
            });
            markers.push({ marker: marker, data: parking }); // 마커와 관련 데이터를 배열에 저장

            var markerListItem = document.createElement('li');
            markerListItem.textContent = parking.name;
            markerListItem.addEventListener('click', function() {
                // 클릭된 마커를 찾아서 지도를 해당 위치로 이동
                map.setCenter(marker.getPosition());
                map.setZoom(15);
            });
            document.getElementById('markerList').appendChild(markerListItem);

            var contentString = '<div><strong>' + parking.name + '</strong><br>' + 
                                '주소: ' + parking.address + '<br>' + 
                                '기본 요금: ' + parking.base_fee + '원<br>' + 
                                '시간당 요금: ' + parking.hourly_fee + '원<br>' + 
                                '유형: ' + parking.type + '</div>' +
                                '<button onclick="redirectToAnotherPage()">이용권 구매하기</button>';

            var infoWindow = new google.maps.InfoWindow({
                content: contentString
            });

            marker.addListener('click', function() {
                infoWindow.open(map, marker);
                map.setCenter(marker.getPosition());
                map.setZoom(15);
            });
        }

        function redirectToAnotherPage() {
            window.location.href = './TicketListTime.hk';
        }

        function search() {
            var keyword = document.getElementById('searchInput').value;
            var geocoder = new google.maps.Geocoder();
            geocoder.geocode({ address: keyword }, function(results, status) {
                if (status === 'OK') {
                    var location = results[0].geometry.location;
                    map.setCenter(location);
                    map.setZoom(15); 
                } else {
                    searchByPlaceName(keyword);
                }
            });
        }

        function searchByPlaceName(placeName) {
            var geocoder = new google.maps.Geocoder();
            geocoder.geocode({ address: placeName }, function(results, status) {
                if (status === 'OK') {
                    var location = results[0].geometry.location;
                    map.setCenter(location);
                    map.setZoom(15); 
                } else {
                    alert('장소를 찾을 수 없습니다.');
                }
            });
        }

        function clearMarkers() {
            for (var i = 0; i < markers.length; i++) {
                markers[i].marker.setMap(null);
            }
        }
    </script>

    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDRoUI4ZJ0PzjfWL4pC_2e4vH0s5S63IgA&callback=initMap" async defer></script>
</body>
</html>
