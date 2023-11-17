<script setup>
import PlanSearch from "@/components/Plan/PlanSearch.vue";
import PlanSearchList from "@/components/Plan/PlanSearchList.vue";
import Search from "@/components/common/Search.vue";
import { ref } from "vue";

const is_expanded = ref(false);

const ToggleMenu = () => {
  is_expanded.value = !is_expanded.value;
};
</script>

<template>
  <aside :class="`${is_expanded && 'is-expanded'}`">
    <div class="logo">
      <img src="@/assets/foot.png" alt="search" />
    </div>

    <div class="menu-toggle-wrap">
      <button class="menu-toggle" @click="ToggleMenu">
        <span class="material-icons"> keyboard_double_arrow_right </span>
      </button>
    </div>

    <div class="menu">
      <Search></Search>
      <PlanSearch />
      <PlanSearchList />
    </div>
  </aside>
</template>

<style lang="scss" scoped>
aside {
  display: flex;
  flex-direction: column;
  width: calc(2rem + 32px);
  min-height: 75vh;
  overflow: hidden;

  padding: 1rem;

  background-color: var(--main-color-bg);
  color: white;

  transition: 0.2s ease-out;

  .logo {
    margin-bottom: 1rem;

    img {
      width: 3rem;
    }
  }

  .menu-toggle-wrap {
    display: flex;
    justify-content: flex-end;
    margin-bottom: 1rem;

    position: relative;
    top: 0;
    transition: 0.2s ease-out;

    .menu-toggle {
      transition: 0.2s ease-out;

      .material-icons {
        font-size: 2rem;
        color: white;
        transition: 0.2s ease-out;
      }

      &:hover {
        .material-icons {
          color: var(--main-color);
          transform: translateX(0.5rem);
        }
      }
    }
  }

  .menu {
    opacity: 0;
  }

  &.is-expanded {
    width: 400px;

    .menu-toggle-wrap {
      top: -3rem;
      .menu-toggle {
        transform: rotate(-180deg);
      }
    }

    .menu {
      opacity: 1;
    }
  }

  @media (max-width: 768px) {
    /* position: fixed; */
    z-index: 10;
  }
}

button {
  cursor: pointer;
  appearance: none;
  border: none;
  outline: none;
  background: none;
}
</style>
