<script setup>
import { RouterLink, useRoute } from "vue-router";
import { usePlanStore } from "@/stores/planStore";
import { storeToRefs } from "pinia";
import { watch } from "vue";
import VKaKaoMap from "@/components/common/VKaKaoMap.vue";
import TimeLine from "@/components/MyList/TimeLine.vue";

const route = useRoute();
const pid = route.params.pid;
const title = route.query.title;
const store = usePlanStore();
const { planItems } = store;
planItems(pid);
</script>

<template>
  <h1>{{ title }}</h1>
  <RouterLink :to="{ name: 'MyList' }">목록으로</RouterLink>
  <!-- 지도 -->
  <div class="mapbox">
    <VKaKaoMap></VKaKaoMap>
  </div>
  <!-- planitem에서 해당 pid를 갖고 있는 모든 item 정보 -->
  <div class="timelinebox">
    <TimeLine />
  </div>
</template>

<style scoped>
.mapbox {
  width: 100%;
  height: 470px;
}
.timelinebox {
  padding: 10 auto;
  width: 100%;
  border: 1px solid black;
  height: 280px;
}
</style>
