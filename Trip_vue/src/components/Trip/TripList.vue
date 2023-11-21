<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import item from "./TripListItem.vue";
import { getTripInfoByTitle } from "@/api/TripApi.js";
// import { getTripInfo } from "@/api/TripApi";
const router = useRouter();
const route = useRoute();
const keyword = route.query.keyword;
const trips = ref([]);

onMounted(() => {
  getTripInfoByTitle(
    keyword,
    (res) => {
      if (res.data.length === 0) {
        alert("검색 결과가 없습니다.");
        router.push("/");

        return;
      }
      trips.value = res.data;
    },
    (e) => {
      console.log(e);
    }
  );
});
</script>
<template>
  <div class="container">
    <h2>여행지 조회 목록</h2>
    <!-- 여행지 썸네일과 그 타이틀이 하나의 컴포넌트가 되고, -->
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
