<script setup>
import { ref, watch, onMounted } from "vue";
import { useTripStore } from "@/stores/tripStore";
import { usePlanStore } from "@/stores/planStore";
import { storeToRefs } from "pinia";
import PlanDetail from "@/components/Plan/PlanDetail.vue";
const store = useTripStore();

const useModal = ref(false);

const { selected: selected, items: tripItems } = storeToRefs(store);

var map;
let selectedMarker = null;
const positions = ref([]);
const markers = ref([]);
const props = defineProps({});
watch(
  selected,
  () => {
    select(selected.value);
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
    center: new kakao.maps.LatLng(37.5013, 127.0397),
    level: 13,
  };
  map = new kakao.maps.Map(container, options);
};
const select = (item) => {
  if (selectedMarker) {
    selectedMarker.setMap(null);
  }
  let position = new kakao.maps.LatLng(item.latitude, item.longitude);
  map.setCenter(position);
  map.setLevel(item.mlevel);
  const marker = new kakao.maps.Marker({
    map: map,
    position: position,
    title: item.title,
    clickable: true,
  });

  selectedMarker = marker;
  kakao.maps.event.addListener(marker, "click", () => {
    useModal.value = true;
  });
};

const deleteMarkers = () => {
  if (markers.value.length > 0) {
    markers.value.forEach((marker) => marker.setMap(null));
  }
};
</script>

<template>
  <PlanDetail :t="selected" v-if="useModal == true" @close-modal="useModal = false" />
  <div id="map"></div>
</template>

<style>
#map {
  width: 100%;
  height: 100%;
}
</style>
