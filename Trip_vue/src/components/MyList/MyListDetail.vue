<script setup>
import { useRoute } from "vue-router";
import { usePlanStore } from "@/stores/planStore";
import { storeToRefs } from "pinia";
import VKaKaoMap from "@/components/common/VKaKaoMap.vue";
const route = useRoute();
const pid = route.params.pid;
const store = usePlanStore();
const { getPlan } = store;
const { plan: plan } = storeToRefs(store);
</script>

<template>
  <!-- pid로 조회한 -->
  <h1>일정제목{{ pid }}</h1>
  <!-- 지도 -->
  <div class="mapbox">
    <VKaKaoMap></VKaKaoMap>
  </div>

  <!-- planitem에서 해당 pid를 갖고 있는 모든 item 정보 -->
  <div class="timelinebox">
    타임라인
    <!-- 각 여행지 메모, 날짜, cost, content_id -> planitem에서 해당 pid로 조회 -->
  </div>
</template>

<style scoped>
.mapbox {
  width: 100%;
  height: 500px;
}
.timelinebox {
  width: 100%;
  border: 1px solid black;
}
</style>
