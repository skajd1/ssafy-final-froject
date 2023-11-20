<script setup>
import { ref, watch } from "vue";
import { useTripStore } from "@/stores/tripStore";
import { storeToRefs } from "pinia";

const store = useTripStore();
const key = ref("");

const { keyword: keyword } = storeToRefs(store);

watch(key, () => {
  keyword.value = key.value;
});
</script>

<template>
  <div id="search">
    <input type="text" placeholder="검색하냥" v-model="key" />
  </div>
</template>

<style lang="scss" scoped>
#search {
  width: 100%;
  text-align: center;
  margin-top: 2rem;
}
#search input {
  width: 100%;
  height: 50px;
  font-size: 30px;
  border: 1px solid var(--main-color);
  border-radius: 10px;
  outline-color: var(--main-color);
  outline-offset: 2px;
  text-align: center;
  color: var(--main-color);
}
input::placeholder {
  color: var(--vt-c-bg);
}
</style>
