<script setup>
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";
import item from "@/components/Plan/PlanSearchListItem.vue";
// import { getTripInfo } from "@/api/TripApi.js";
const route = useRoute();
onMounted(() => {
  let sido = route.params.sido;
  let gugun = route.params.gugun;
  let typeid = route.params.theme;
  // getTripInfo(
  //   sido,
  //   gugun,
  //   typeid,
  //   (res) => {
  //     console.log(res.data);
  //     trips.value = res.data;
  //   },
  //   (e) => {
  //     console.log(e);
  //   }
  // );
});

const trips = ref([]);
</script>
<template>
  <div class="container">
    <h2>여행지 조회 목록</h2>
    <!-- 여행지 썸네일과 그 타이틀이 하나의 컴포넌트가 되고, -->
    <!-- 필터에 맞는 컴포넌트가 여러개 조회된다. -->
    <!-- 가로로 스크롤바 -->
    <div id="items">
      <item v-for="trip in trips" :key="trip.tid" :t="trip"></item>
    </div>
  </div>
</template>

<style scoped>
#items {
  display: flex;
  flex-wrap: nowrap;
  overflow-x: auto;
  overflow-y: hidden;
  margin: 1 auto;
  padding: 0;
  width: 100%;
  height: 100%;
}
</style>
