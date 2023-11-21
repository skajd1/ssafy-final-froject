<script setup>
import { watch, reactive } from "vue";
import item from "@/components/Plan/PlanSearchListItem.vue";
import { useTripStore } from "@/stores/tripStore";
import { storeToRefs } from "pinia";

const tripStore = useTripStore();

const { lists, searchData, thema } = storeToRefs(tripStore);
const { getTripList } = tripStore;

const trips = reactive([]);

watch(lists, () => {
  trips.value = lists;
  console.log(trips.value);
});

watch(
  searchData,
  () => {
    getTripList();
  },
  { deep: true }
);

watch(
  thema,
  () => {
    filterThema();
  },
  { deep: true }
);

const filterThema = () => {};
</script>

<template>
  <div class="container">
    <p>여행지 조회 목록</p>
    <!-- 여행지 썸네일과 그 타이틀이 하나의 컴포넌트가 되고, -->
    <!-- 필터에 맞는 컴포넌트가 여러개 조회된다. -->
    <!-- 가로로 스크롤바 -->
    <div id="items">
      <item v-for="trip in trips.value" :t="trip"></item>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.container {
  width: 300px;
  height: 300px;

  background-color: var(--main-color);

  #items {
    overflow-y: auto;
    margin: 1 auto;
    padding: 0;
    width: 100%;
    height: 100%;
  }
}
</style>
