<script setup>
import { ref, watch, onMounted } from "vue";
import { useTripStore } from "@/stores/tripStore";
import { storeToRefs } from "pinia";
const store = useTripStore();

const { selected: selected, items: tripItems } = storeToRefs(store);

var map;
const positions = ref([]);
const markers = ref([]);
const infoWindows = ref([]);
const props = defineProps({});
watch(
  selected,
  () => {
    map.setCenter(new kakao.maps.LatLng(selected.value.latitude, selected.value.longitude));
    deleteIw();
  },
  { deep: true }
);
onMounted(() => {
  if (window.kakao && window.kakao.maps) {
    initMap();
  } else {
    const script = document.createElement("script");
    script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${
      import.meta.env.VITE_KAKAO_MAP_SERVICE_KEY
    }&libraries=services,clusterer`;
    /* global kakao */
    script.onload = () => kakao.maps.load(() => initMap());
    document.head.appendChild(script);
  }
});
const initMap = () => {
  const container = document.getElementById("map");
  const options = {
    center: new kakao.maps.LatLng(33.450701, 126.570667),
    level: 10,
  };
  map = new kakao.maps.Map(container, options);
  setTimeout(() => {
    setPosition();
    loadMarkers();
  }, 500);
};
function setPosition() {
  positions.value = [];
  tripItems.value.forEach((item) => {
    positions.value.push({
      title: item.title,
      latlng: new kakao.maps.LatLng(item.latitude, item.longitude),
      addr: item.addr1,
      tel: item.tel,
    });
  });
  console.log(positions.value);
}

const loadMarkers = () => {
  // 현재 표시되어있는 marker들이 있다면 map에 등록된 marker를 제거한다.
  deleteMarkers();

  markers.value = [];
  positions.value.forEach((position, index) => {
    const marker = new kakao.maps.Marker({
      map: map,
      position: position.latlng,
      title: position.title,
      clickable: true,
      // image: markerImage, // 마커의 이미지
    });

    markers.value.push(marker);

    let infoWindow = new kakao.maps.InfoWindow({
      position: position.latlng,
      removable: true,
      content: `
        <div style="width:240px;height:160px;text-align:center;padding:6px 0;">
            <div>
            ${position.title}
            </div>
            <div>
              ${position.addr}
            </div>
            <div>
              ${position.tel}
            </div>
            <br>
            <div style = "margin-left : 140px;">
              <button onclick="deleteIw()">닫기</button>
            </div>              
        </div>
        `,
    });
    // infoWindow.open(map, marker);
    infoWindows.value.push(infoWindow);
    kakao.maps.event.addListener(marker, "click", () => {
      selectData(index);
    });
  });

  map.setCenter(positions.value[0].latlng);

  // // 4. 지도를 이동시켜주기
  // 배열.reduce( (누적값, 현재값, 인덱스, 요소)=>{ return 결과값}, 초기값);
  // const bounds = positions.value.reduce(
  //   (bounds, position) => bounds.extend(position.latlng),
  //   new kakao.maps.LatLngBounds()
  // );
  // 마커 클릭이벤트
};

const deleteMarkers = () => {
  if (markers.value.length > 0) {
    markers.value.forEach((marker) => marker.setMap(null));
  }
};
const deleteIw = () => {
  if (infoWindows.value.length > 0) {
    infoWindows.value.forEach((infoWindow) => infoWindow.close());
  }
};
const selectData = (index) => {
  deleteIw();
  infoWindows.value[index].open(map, markers.value[index]);
};
</script>

<template>
  <div id="map"></div>
</template>

<style>
#map {
  width: 100%;
  height: 100%;
}
</style>
