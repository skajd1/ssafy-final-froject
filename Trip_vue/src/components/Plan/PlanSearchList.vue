<script setup>
import { ref, watch, reactive } from "vue";
import item from "@/components/Plan/PlanSearchListItem.vue";
import { useTripStore } from "@/stores/tripStore";
import { storeToRefs } from "pinia";

const tripStore = useTripStore();

const { lists, searchData } = storeToRefs(tripStore);
const { getTripList } = tripStore;

const trips = reactive([]);

watch(lists, () => {
  trips.value = lists;
});

watch(
  searchData,
  () => {
    getTripList();
    console.log(searchData.value);
  },
  { deep: true }
);
</script>

<template>
  <div class="container">
    <h2>여행지 조회 목록</h2>
    <!-- 여행지 썸네일과 그 타이틀이 하나의 컴포넌트가 되고, -->
    <!-- 필터에 맞는 컴포넌트가 여러개 조회된다. -->
    <!-- 가로로 스크롤바 -->
    <div id="items">
      <item v-for="trip in trips" :t="trip"></item>
    </div>
  </div>
</template>

<style scoped>
.container {
  width: 300px;
  background-color: var(--main-color);
}

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
